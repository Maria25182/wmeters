package com.umanizales.wmeters.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CosumptionDTO {

    private String uidCosumption;
    @NotNull
    private LocalDate dateCapture;
    @NotNull
    private Double consumption;



}
