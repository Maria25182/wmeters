package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.CosumptionAble;
import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionEntity;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Qualifier("PostgresCosumptionRepository")
@Repository("cosumptionPersistence")
public class PostgresCosumptionRepository implements CosumptionAble {
    @Autowired
    private CosumptionRepository cosumptionRepository;
    @Override
    public CosumptionDTO save(CosumptionDTO cosumptionDTO) {
        return  cosumptionRepository.save(new CosumptionEntity(cosumptionDTO)).tocosumptionDTO();

    }

    @Override
    public CosumptionDTO update(CosumptionDTO cosumptionDTO) {
        return cosumptionRepository.save(new CosumptionEntity(cosumptionDTO)).tocosumptionDTO();
    }

    @Override
    public boolean delete(String code) {
       cosumptionRepository.deleteById(code);
        return true;
    }

    @Override
    public List<CosumptionDTO> list() {
       List<CosumptionEntity> cosumptions = cosumptionRepository.findAll();
       List<CosumptionDTO> cosumptionDTO = new ArrayList<>();
       for(CosumptionEntity cosumptio: cosumptions){
            cosumptionDTO.add(cosumptio.tocosumptionDTO());
       }
       return cosumptionDTO;
    }
}
