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
public class CustomerDTO{
    private String uidCustomer;
    @NotNull
    private String nameCustomer;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String address;
    @NotNull
    private String supplier;
    @NotNull
    private Integer phone;
    @NotNull
    private String password;
}
