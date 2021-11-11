package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.DeviceDTO;
import com.umanizales.wmeters.exception.WmeterException;
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
    public boolean update(String code, DeviceDTO DeviceDTO) {
        return devicePersistence.update(code,DeviceDTO);
    }

    @Override
    public boolean delete(String code) throws WmeterException {
        return  devicePersistence.delete(code);

    }

    @Override
    public List<DeviceDTO> list() {
        return devicePersistence.list();
    }
}
