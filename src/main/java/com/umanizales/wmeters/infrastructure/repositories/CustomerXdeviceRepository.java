package com.umanizales.wmeters.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerXdeviceRepository extends JpaRepository<CustomerXdeviceEntity, String> {
    @Query("SELECT cusxdevice FROM CustomerXdeviceEntity cusxdevice")
    List<CustomerXdeviceEntity> getCustomerXdeviceEntity();



    @Transactional
    @Modifying
    @Query("UPDATE CustomerXdeviceEntity  d SET " +
            "d.dateInstallation = :#{#CustomerEntity.dateInstallation }, "+
            "d.uid_Cosumption= :#{#CustomerXdeviceEntity.uid_Cosumption}," +
            "d.uid_Customer= :#{#CustomerXdeviceEntity.uid_Customer}," +
            "d.uid_Device= :#{#CustomerXdeviceEntity.uid_Device} WHERE d.uidCustomerXdevice LIKE :code")
    public int update(@Param("CustomerXdeviceEntity") CustomerEntity customer, @Param("code") String code);
}
