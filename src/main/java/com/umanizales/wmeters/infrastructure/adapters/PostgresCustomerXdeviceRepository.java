package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.CustomerXdeviceAble;
import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
import com.umanizales.wmeters.exception.WmeterException;
import com.umanizales.wmeters.infrastructure.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Qualifier("PostgresCustomerXdeviceRepository")
@Repository("customerXdevicePersistence")
public class PostgresCustomerXdeviceRepository implements  CustomerXdeviceAble{
   @Autowired
    private CustomerXdeviceRepository customerXdeviceRepository;
    @Override
    public CustomerXdeviceDTO save(CustomerXdeviceDTO CustomerXdeviceDTO) {
        return  customerXdeviceRepository.save(new CustomerXdeviceEntity(CustomerXdeviceDTO)).tocustomexDevicerDTO();
    }

    @Override
    public CustomerXdeviceDTO update(CustomerXdeviceDTO CustomerXdeviceDTO) {
     return  null;
    }

    @Override
    public boolean delete(String code) throws WmeterException {
        if(customerXdeviceRepository.existsById(code)) {
            try{
                customerXdeviceRepository.deleteById(code);
                return true;

        }catch(Exception e){
            throw  new WmeterException("el codigo no se puede eliminar"+e);
        }
        }else{
            throw new WmeterException("El codigo a borrar no existe" + code);
        }
    }
    @Override
    public List<CustomerXdeviceDTO> list() {

        List<CustomerXdeviceDTO> customerXdeviceDTOS = new ArrayList<>();
        customerXdeviceRepository.getCustomerXdeviceEntity().forEach(cos -> customerXdeviceDTOS.add(cos.tocustomexDevicerDTO()));
        return customerXdeviceDTOS;
    }

}