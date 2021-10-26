package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CosumptionDTO;

import java.util.List;

public interface CosumptionAble {
    CosumptionDTO save(CosumptionDTO cosumptionDTO);
    CosumptionDTO update(CosumptionDTO cosumptionDTO);
    boolean delete(String code);
    List<CosumptionDTO> list();
}
