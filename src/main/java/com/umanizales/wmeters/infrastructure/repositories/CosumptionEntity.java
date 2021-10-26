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
@Table(name = "cosumption", schema = "public", catalog = "wmeter")
public class CosumptionEntity {
    @Id
    @Column(name = "uid_cosumption", nullable = false, length = -1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uidCosumption;

    @Basic
    @Column(name = "date_capture", nullable = true)
    private Date dateCapture;
    @Basic
    @Column(name = "consumption", nullable = true, precision = 0)
    private Double consumption;



}
