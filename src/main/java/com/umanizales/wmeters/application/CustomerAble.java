package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerDTO;

import java.util.List;

public interface CustomerAble {
    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO update(CustomerDTO customerDTO);
    boolean delete(String code);
    List<CustomerDTO> list();
}
