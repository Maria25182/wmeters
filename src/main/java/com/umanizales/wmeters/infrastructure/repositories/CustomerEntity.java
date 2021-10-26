package com.umanizales.wmeters.infrastructure.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "customer", schema = "public", catalog = "wmeter")
public class CustomerEntity {
    @Id
    @Column(name = "uid_customer", nullable = false, length = -1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uidCustomer;
    @Basic
    @Column(name = "name_customer", nullable = true, length = -1)
    private String nameCustomer;
    @Basic
    @Column(name = "last_name", nullable = true, length = -1)
    private String lastName;
    @Basic
    @Column(name = "email", nullable = true, length = -1)
    private String email;
    @Basic
    @Column(name = "address", nullable = true, length = -1)
    private String address;
    @Basic
    @Column(name = "supplier", nullable = true, length = -1)
    private String supplier;
    @Basic
    @Column(name = "phone", nullable = true)
    private Integer phone;
    @Basic
    @Column(name = "password", nullable = true, length = -1)
    private String password;


}
