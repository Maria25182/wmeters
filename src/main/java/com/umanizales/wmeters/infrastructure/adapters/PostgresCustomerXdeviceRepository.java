package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.CustomerXdeviceAble;
import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionEntity;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionRepository;
import com.umanizales.wmeters.infrastructure.repositories.CustomerXdeviceEntity;
import com.umanizales.wmeters.infrastructure.repositories.CustomerXdeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Qualifier("PostgresCustomerXdeviceRepository")
@Repository("customerXdevicePersistence")
public class PostgresCustomerXdeviceRepository {
 /*   @Autowired
    private CustomerXdeviceRepository customerXdeviceRepository;
    @Override
    public CustomerXdeviceDTO save(CustomerXdeviceDTO CustomerXdeviceDTO) {
        return  customerXdeviceRepository.save(new CustomerXdeviceEntity(CustomerXdeviceDTO)).tocustomerxDeviceDTO();
    }

    @Override
    public CustomerXdeviceDTO update(CustomerXdeviceDTO CustomerXdeviceDTO) {
        return  customerXdeviceRepository.save(new CustomerXdeviceEntity(CustomerXdeviceDTO)).tocustomerxDeviceDTO();
    }

    @Override
    public boolean delete(String code) {
       customerXdeviceRepository.deleteById(code);
        return true;
    }

    @Override
    public List<CustomerXdeviceDTO> list() {
        return null;
    }

*/
}