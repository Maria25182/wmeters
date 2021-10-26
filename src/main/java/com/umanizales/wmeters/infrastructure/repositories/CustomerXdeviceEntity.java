package com.umanizales.wmeters.infrastructure.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "customerXdevice", schema = "public", catalog = "wmeter")
@IdClass(CustomerXdeviceEntityPK.class)
public class CustomerXdeviceEntity {
    @Id
    @Column(name = "uid_customer", nullable = false, length = -1)
    private String uidCustomer;
    @Id
    @Column(name = "uid_device", nullable = false, length = -1)
    private String uidDevice;
    @Basic
    @Column(name = "date_installation", nullable = false)
    private Date dateInstallation;
    @ManyToOne
    @JoinColumn(name = "uid_customer", referencedColumnName = "uid_customer", nullable = false)
    private CustomerEntity uid_customer;
    @ManyToOne
    @JoinColumn(name = "uid_cosumption", referencedColumnName = "uid_cosumption", nullable = false)
    private CosumptionEntity uid_cosumption;



}
