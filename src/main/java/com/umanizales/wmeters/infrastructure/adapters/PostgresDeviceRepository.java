package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.DeviceAble;
import com.umanizales.wmeters.domain.DeviceDTO;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionEntity;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionRepository;
import com.umanizales.wmeters.infrastructure.repositories.DeviceEntity;
import com.umanizales.wmeters.infrastructure.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Qualifier("PostgresDeviceRepository")
@Repository("devicePersistence")
public class PostgresDeviceRepository implements DeviceAble {
    @Autowired
    private DeviceRepository deviceRepository;
    @Override
    public DeviceDTO save(DeviceDTO DeviceDTO) {
        return  deviceRepository.save(new DeviceEntity(DeviceDTO)).todeviceDTO();
    }

    @Override
    public DeviceDTO update(DeviceDTO DeviceDTO) {
        return  deviceRepository.save(new DeviceEntity(DeviceDTO)).todeviceDTO();
    }

    @Override
    public boolean delete(String code) {
      deviceRepository.deleteById(code);
        return true;
    }

    @Override
    public List<DeviceDTO> list() {
        return null;
    }
}
