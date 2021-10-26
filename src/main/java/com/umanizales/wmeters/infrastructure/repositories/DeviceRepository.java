package com.umanizales.wmeters.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<DeviceEntity, String> {
}
