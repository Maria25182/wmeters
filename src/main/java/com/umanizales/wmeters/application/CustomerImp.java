package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.exception.WmeterException;
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
    public boolean update(String code,CustomerDTO CustomerDTO) {
        return customerPersistence.update(code,CustomerDTO);
    }

    @Override
    public boolean delete(String code)throws WmeterException {

        return  customerPersistence.delete(code);
    }

    @Override
    public List<CustomerDTO> list() {
        return customerPersistence.list();
    }
}
