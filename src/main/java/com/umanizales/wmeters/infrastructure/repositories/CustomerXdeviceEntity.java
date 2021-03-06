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
import java.util.Date;
import java.util.UUID;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "customerxdevice", schema = "public", catalog = "wmeter")
public class CustomerXdeviceEntity {

    @Basic
    @Column(name = "date_installation", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateInstallation;
    @Id
    @Column(name = "uid_customerxdevice", nullable = false)
    private String uidCustomerXdevice;
    @ManyToOne
    @JoinColumn(name = "uid_customer", referencedColumnName = "uid_customer", nullable = false)
    private CustomerEntity uidCustomer;
    @ManyToOne
    @JoinColumn(name = "uid_device", referencedColumnName = "uid_device", nullable = false)
    private DeviceEntity uidDevice;
    @ManyToOne
    @JoinColumn(name = "uid_cosumption", referencedColumnName = "uid_cosumption", nullable = false)
    private CosumptionEntity uidCosumption;



    public CustomerXdeviceEntity(CustomerXdeviceDTO customerxDeviceDTO) {
        BeanUtils.copyProperties(customerxDeviceDTO,this);
        //generar uid
        this.uidCustomer =new CustomerEntity();
        this.uidCustomer.setUidCustomer(customerxDeviceDTO.getUidCustomer().getUidCustomer());
        this.uidCosumption =new CosumptionEntity();
        this.uidCosumption.setUidCosumption(customerxDeviceDTO.getUidCosumption().getUidCosumption());
        this.uidDevice =new DeviceEntity();
        this.uidDevice.setUidDevice(customerxDeviceDTO.getUidDevice().getUidDevice());
        this.uidCustomerXdevice = UUID.randomUUID().toString();
        this.dateInstallation = customerxDeviceDTO.getDateInstallation();
    }

    public CustomerXdeviceDTO tocustomexDevicerDTO(){
        CustomerXdeviceDTO customerXdeviceDTO= new CustomerXdeviceDTO();
        BeanUtils.copyProperties(this,customerXdeviceDTO);
        return customerXdeviceDTO;
    }
}
