package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.exception.WmeterException;

import java.util.List;

public interface CosumptionAble {
    CosumptionDTO save(CosumptionDTO cosumptionDTO);
    boolean update(String code,CosumptionDTO cosumptionDTO);
    boolean delete(String code) throws WmeterException;
    List<CosumptionDTO> list();
}
