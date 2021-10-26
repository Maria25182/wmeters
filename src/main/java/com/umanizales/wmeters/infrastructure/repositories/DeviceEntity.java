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
@Table(name = "device", schema = "public", catalog = "wmeter")
public class DeviceEntity {
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uidDevice;
    @Id
    @Column(name = "uid_device", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;



}
