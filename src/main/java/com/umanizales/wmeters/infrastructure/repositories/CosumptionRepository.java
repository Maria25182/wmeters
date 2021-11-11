package com.umanizales.wmeters.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CosumptionRepository extends JpaRepository<CosumptionEntity,String> {

    @Query("SELECT cos FROM CosumptionEntity cos")
    List<CosumptionEntity> getCosumption();


    @Transactional
    @Modifying
    @Query("UPDATE CosumptionEntity d SET d.dateCapture = :#{#CosumptionEntity.dateCapture}," +
            " d.consumption = :#{#CosumptionEntity.consumption} WHERE d.uidCosumption LIKE :code")
    public int update(@Param("CosumptionEntity") CosumptionEntity cosumption, @Param("code") String code);
}
