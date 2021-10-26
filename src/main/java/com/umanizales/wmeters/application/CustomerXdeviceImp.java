package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class CustomerXdeviceImp implements CustomerAble {
    @Autowired
    @Qualifier("PostgresCustomerXdeviceRepository")
    private CustomerXdeviceAble customerXdevicePersistence;
    @Override
    public CustomerDTO save(CustomerDTO CustomerDTO) {
        return null;
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
        return null;
    }
}
