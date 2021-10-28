package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.CustomerXdeviceAble;
import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
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
        return  customerXdeviceRepository.save(new CustomerXdeviceEntity(CustomerXdeviceDTO)).tocustomerxDeviceDTO();
    }

    @Override
    public CustomerXdeviceDTO update(CustomerXdeviceDTO CustomerXdeviceDTO) {
     return  null;
    }

    @Override
    public boolean delete(String code) {
       customerXdeviceRepository.deleteById(code);
        return true;
    }
    @Override
    public List<CustomerXdeviceDTO> list() {
        List<CustomerXdeviceEntity> customers = customerXdeviceRepository.findAll();
        List<CustomerXdeviceDTO> customerXdeviceDTOS = new ArrayList<>();
        for(CustomerXdeviceEntity cusxdevice: customers){
           customerXdeviceDTOS.add(cusxdevice.tocustomerxDeviceDTO());
        }
        return customerXdeviceDTOS;
    }

}