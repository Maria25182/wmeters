package com.umanizales.wmeters.infrastructure.repositories;

import com.umanizales.wmeters.domain.CosumptionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

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
    private LocalDate dateCapture;
    @Basic
    @Column(name = "consumption", nullable = true, precision = 0)
    private Double consumption;

    public CosumptionEntity(CosumptionDTO cosumptionDTO) {
        BeanUtils.copyProperties(cosumptionDTO,this);
        //generar uid
        this.uidCosumption = UUID.randomUUID().toString();
    }

    public CosumptionDTO tocosumptionDTO(){
        CosumptionDTO cosumptionDTO = new CosumptionDTO();
        BeanUtils.copyProperties(this,cosumptionDTO);
        return cosumptionDTO;
    }
}
