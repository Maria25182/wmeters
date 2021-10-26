package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerDTO;

import java.util.List;

public interface CustomerAble {
    CustomerDTO save(CustomerDTO CustomerDTO);
    CustomerDTO update(CustomerDTO CustomerDTO);
    boolean delete(String code);
    List<CustomerDTO> list();
}
