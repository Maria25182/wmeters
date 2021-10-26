package com.umanizales.wmeters.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO extends CustomerXdeviceDTO {
    @NotNull
    @NotEmpty
    private String uidCustomer;
    @NotNull
    @NotEmpty
    private String nameCustomer;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    @NotEmpty
    private String supplier;
    @NotNull
    @NotEmpty
    @Positive
    private Integer phone;
    @NotNull
    @NotEmpty
    private String password;
}
