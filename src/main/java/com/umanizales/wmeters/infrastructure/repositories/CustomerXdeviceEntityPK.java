package com.umanizales.wmeters.infrastructure.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerXdeviceEntityPK implements Serializable {
    @Column(name = "uid_customer", nullable = false, length = -1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uidCustomer;
    @Column(name = "uid_device", nullable = false, length = -1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uidDevice;


}
