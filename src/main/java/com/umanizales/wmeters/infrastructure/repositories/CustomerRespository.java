package com.umanizales.wmeters.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<CustomerEntity,String> {
}
