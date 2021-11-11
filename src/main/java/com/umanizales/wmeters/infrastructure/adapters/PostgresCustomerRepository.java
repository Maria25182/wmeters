package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.CosumptionAble;
import com.umanizales.wmeters.application.CustomerAble;
import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.exception.WmeterException;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionEntity;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionRepository;
import com.umanizales.wmeters.infrastructure.repositories.CustomerEntity;
import com.umanizales.wmeters.infrastructure.repositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Qualifier("PostgresCustomerRepository")
@Repository("customerPersistence")
public class PostgresCustomerRepository implements CustomerAble {
    @Autowired
    private CustomerRespository customerRepository;
    @Override
    public CustomerDTO save(CustomerDTO CustomerDTO) {
        return  customerRepository.save(new CustomerEntity(CustomerDTO)).tocustomerDTO();
    }

    @Override
    public boolean update(String code, CustomerDTO CustomerDTO) {
        return customerRepository.update(new CustomerEntity(CustomerDTO),code)>=1;
        //customerRepository.
    }

    @Override
    public boolean delete(String code)throws WmeterException {
        if(customerRepository.existsById(code)){
            try{
                customerRepository.deleteById(code);
                return true;
            }catch(Exception e){
                throw  new WmeterException("el codigo no se puede eliminar"+e);
            }

        }else{
            throw new WmeterException("El codigo a borrar no existe" + code);
            }
    }

    @Override
    public List<CustomerDTO> list() {
        List<CustomerDTO> customerDTO = new ArrayList<>();
        customerRepository.getCustomer().forEach(cos -> customerDTO.add(cos.tocustomerDTO()));
        return customerDTO;
    }

}
