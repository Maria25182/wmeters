package com.umanizales.wmeters.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CosumptionDTO {
    @NotNull
    @NotEmpty
    private String uidCosumption;
    @NotNull
    @NotEmpty
    private LocalDate dateCapture;
    @NotNull
    @NotEmpty
    private Double consumption;

}
