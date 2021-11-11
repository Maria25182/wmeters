package com.umanizales.wmeters.domain;

import com.umanizales.wmeters.infrastructure.repositories.CosumptionEntity;
import com.umanizales.wmeters.infrastructure.repositories.CustomerEntity;
import com.umanizales.wmeters.infrastructure.repositories.DeviceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerXdeviceDTO {



    private Date dateInstallation;


    private DeviceEntity uid_device;

    private CustomerEntity uid_customer;

    private CosumptionEntity uid_cosumption;
}
