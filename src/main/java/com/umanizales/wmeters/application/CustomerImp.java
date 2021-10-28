package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.infrastructure.repositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerImp implements CustomerAble{
    @Autowired
    @Qualifier("PostgresCustomerRepository")
    private CustomerAble customerPersistence;
    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return customerPersistence.save(customerDTO);
    }

    @Override
    public CustomerDTO update(CustomerDTO CustomerDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<CustomerDTO> list() {
        return customerPersistence.list();
    }
}
