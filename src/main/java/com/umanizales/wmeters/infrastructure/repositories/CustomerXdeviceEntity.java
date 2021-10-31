package com.umanizales.wmeters.infrastructure.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "customerXdevice", schema = "public", catalog = "wmeter")
public class CustomerXdeviceEntity {

    @Basic
    @Column(name = "date_installation", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateInstallation;
    @Id
    @Column(name = "uid_customerXdevice", nullable = false, length = -1)
    private String uidCustomerXdevice;
    @ManyToOne
    @JoinColumn(name = "uid_customer", referencedColumnName = "uid_customer", nullable = false)
    private CustomerEntity uid_Customer;
    @ManyToOne
    @JoinColumn(name = "uid_device", referencedColumnName = "uid_device", nullable = false)
    private DeviceEntity uid_Device;
    @ManyToOne
    @JoinColumn(name = "uid_cosumption", referencedColumnName = "uid_cosumption", nullable = false)
    private CosumptionEntity uid_Cosumption;



    public CustomerXdeviceEntity(CustomerXdeviceDTO customerxDeviceDTO) {
        BeanUtils.copyProperties(customerxDeviceDTO,this);
        //generar uid
        this.uidCustomerXdevice = UUID.randomUUID().toString();
    }

    public CustomerXdeviceDTO tocustomexDevicerDTO(){
        CustomerXdeviceDTO customerXdeviceDTO= new CustomerXdeviceDTO();
        BeanUtils.copyProperties(this,customerXdeviceDTO);
        return customerXdeviceDTO;
    }
}
