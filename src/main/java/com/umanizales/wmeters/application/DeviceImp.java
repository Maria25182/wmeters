package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class DeviceImp implements DeviceAble{
    @Autowired
    @Qualifier("PostgresDeviceRepository")
    private DeviceAble devicePersistence;
    @Override
    public DeviceDTO save(DeviceDTO DeviceDTO) {
        return null;
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
        return null;
    }
}
