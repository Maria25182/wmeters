package com.umanizales.wmeters.application;

import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.exception.WmeterException;
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
    public boolean update(String code,CosumptionDTO cosumptionDTO) {
        return cosumptionPersistence.update(code,cosumptionDTO);
    }

    @Override
    public boolean delete(String code) throws WmeterException {

    return  cosumptionPersistence.delete(code);

    }

    @Override
    public List<CosumptionDTO> list() {
        return cosumptionPersistence.list();
    }
}
