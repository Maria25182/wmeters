package com.umanizales.wmeters.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRespository extends JpaRepository<CustomerEntity,String> {
    @Query("SELECT cus FROM CustomerEntity cus")
    List<CustomerEntity> getCustomer();


    @Transactional
    @Modifying
    @Query("UPDATE CustomerEntity d SET d.nameCustomer = :#{#CustomerEntity.nameCustomer}, "+
            "d.lastName= :#{#CustomerEntity.lastName}," +
            "d.email= :#{#CustomerEntity.email}," +
            "d.address= :#{#CustomerEntity.address}," +
            "d.supplier= :#{#CustomerEntity.supplier}," +
            "d.phone= :#{#CustomerEntity.phone}," +
            "d.password= :#{#CustomerEntity.password} WHERE d.uidCustomer LIKE :code")
    public int update(@Param("CustomerEntity") CustomerEntity customer, @Param("code") String code);
}
