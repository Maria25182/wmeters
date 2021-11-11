package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.DeviceDTO;
import com.umanizales.wmeters.exception.WmeterException;

import java.util.List;

public interface DeviceAble {
    DeviceDTO save(DeviceDTO DeviceDTO);
    boolean update(String code,DeviceDTO DeviceDTO);
    boolean delete(String code)throws WmeterException;
    List<DeviceDTO> list();
}
