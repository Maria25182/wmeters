package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.CosumptionAble;
import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.exception.WmeterException;
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
    public boolean update(String code,CosumptionDTO cosumptionDTO) {
        return cosumptionRepository.update(new CosumptionEntity(cosumptionDTO),code)>=1;
    }

    @Override
    public boolean delete(String code)throws WmeterException {

        if (cosumptionRepository.existsById(code)) {
            try {
                cosumptionRepository.deleteById(code);
                return true;
            } catch (Exception e) {
              throw  new WmeterException("el codigo"+e);
            }


        } else {
            throw new WmeterException("El codigo a borrar no existe" + code);
        }


    }

    @Override
    public List<CosumptionDTO> list() {
       List<CosumptionDTO> cosumptionDTO = new ArrayList<>();
       cosumptionRepository.getCosumption().forEach(cos -> cosumptionDTO.add(cos.tocosumptionDTO()));
       return cosumptionDTO;
    }

}
