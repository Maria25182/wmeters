package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.DeviceDTO;

import java.util.List;

public interface DeviceAble {
    DeviceDTO save(DeviceDTO DeviceDTO);
    DeviceDTO update(DeviceDTO DeviceDTO);
    boolean delete(String code);
    List<DeviceDTO> list();
}
