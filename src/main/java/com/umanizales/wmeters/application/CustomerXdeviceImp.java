package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
import com.umanizales.wmeters.exception.WmeterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerXdeviceImp implements CustomerXdeviceAble {
    @Autowired
    @Qualifier("PostgresCustomerXdeviceRepository")
    private CustomerXdeviceAble customerXdevicePersistence;
    @Override
    public CustomerXdeviceDTO save(CustomerXdeviceDTO customerXdeviceDTO) {
        return customerXdevicePersistence.save(customerXdeviceDTO);
    }

    @Override
    public boolean update(String code,CustomerXdeviceDTO CustomerxDeviceDTO) {
        return customerXdevicePersistence.update(code,CustomerxDeviceDTO);
    }

    @Override
    public boolean delete(String code) throws WmeterException {

        return  customerXdevicePersistence.delete(code);

    }

    @Override
    public List<CustomerXdeviceDTO> list() {
        return customerXdevicePersistence.list();
    }
}
