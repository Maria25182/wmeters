package com.umanizales.wmeters.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeviceRepository extends JpaRepository<DeviceEntity, String> {
    @Query("SELECT dev FROM DeviceEntity dev")
    List< DeviceEntity> getDevice();

    @Transactional
    @Modifying
    @Query("UPDATE DeviceEntity d SET " +
            "d.name =:#{#DeviceEntity.name}, "+
            "d.description =:#{#DeviceEntity.description} WHERE d.uidDevice LIKE :code")
    public int update(@Param("DeviceEntity") DeviceEntity customer, @Param("code") String code);
}
