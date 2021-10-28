package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceImp implements DeviceAble{
    @Autowired
    @Qualifier("PostgresDeviceRepository")
    private DeviceAble devicePersistence;
    @Override
    public DeviceDTO save(DeviceDTO deviceDTO) {
        return devicePersistence.save(deviceDTO);
    }

    @Override
    public DeviceDTO update(DeviceDTO DeviceDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<DeviceDTO> list() {
        return devicePersistence.list();
    }
}
