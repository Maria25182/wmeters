package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.CustomerAble;
import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.domain.CustomerDTO;
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
    public CustomerDTO update(CustomerDTO CustomerDTO) {
        return  customerRepository.save(new CustomerEntity(CustomerDTO)).tocustomerDTO();
    }

    @Override
    public boolean delete(String code) {
        customerRepository.deleteById(code);
        return true;
    }

    @Override
    public List<CustomerDTO> list() {

        List<CustomerEntity> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTO = new ArrayList<>();
        for(CustomerEntity custome: customers){
            customerDTO.add(custome.tocustomerDTO());
        }
        return customerDTO;
    }

}
