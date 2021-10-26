package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerXdeviceDTO;

import java.util.List;

public interface CustomerXdeviceAble {
    CustomerXdeviceDTO save(CustomerXdeviceDTO CustomerXdeviceDTO);
    CustomerXdeviceDTO update(CustomerXdeviceDTO CustomerXdeviceDTO);
    boolean delete(String code);
    List<CustomerXdeviceDTO> list();
}
