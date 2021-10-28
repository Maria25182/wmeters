package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CosumptionImp implements CosumptionAble{
    @Autowired
    @Qualifier("PostgresCosumptionRepository")
    private CosumptionAble cosumptionPersistence;
    @Override
    public CosumptionDTO save(CosumptionDTO cosumptionDTO) {
        return cosumptionPersistence.save(cosumptionDTO);
    }

    @Override
    public CosumptionDTO update(CosumptionDTO cosumptionDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<CosumptionDTO> list() {
        return cosumptionPersistence.list();
    }
}
