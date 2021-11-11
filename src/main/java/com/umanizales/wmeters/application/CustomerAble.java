package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.exception.WmeterException;

import java.util.List;

public interface CustomerAble {
    CustomerDTO save(CustomerDTO customerDTO);
    boolean update(String code,CustomerDTO customerDTO);
    boolean delete(String code)throws WmeterException;
    List<CustomerDTO> list();
}
