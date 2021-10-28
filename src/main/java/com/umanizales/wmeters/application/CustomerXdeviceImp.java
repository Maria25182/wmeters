package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerXdeviceImp implements CustomerXdeviceAble {

    @Qualifier("PostgresCustomerXdeviceRepository")
    private CustomerXdeviceAble customerXdevicePersistence;
    @Override
    public CustomerXdeviceDTO save(CustomerXdeviceDTO customerXdeviceDTO) {
        return customerXdevicePersistence.save(customerXdeviceDTO);
    }

    @Override
    public CustomerXdeviceDTO update(CustomerXdeviceDTO CustomerDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<CustomerXdeviceDTO> list() {
        return customerXdevicePersistence.list();
    }
}
