package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
import com.umanizales.wmeters.exception.WmeterException;

import java.util.List;

public interface CustomerXdeviceAble {
    CustomerXdeviceDTO save(CustomerXdeviceDTO CustomerXdeviceDTO);
    boolean update(String code,CustomerXdeviceDTO CustomerXdeviceDTO);
    boolean delete(String code)throws WmeterException;
    List<CustomerXdeviceDTO> list();
}
