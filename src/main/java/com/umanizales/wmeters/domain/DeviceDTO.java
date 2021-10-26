package com.umanizales.wmeters.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {
    @NotNull
    @NotEmpty
    private String uidDevice;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull

    private String description;
}
