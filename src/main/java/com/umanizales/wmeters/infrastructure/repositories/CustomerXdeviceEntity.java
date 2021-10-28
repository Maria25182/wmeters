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
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "customerXdevice", schema = "public", catalog = "wmeter")
@IdClass(CustomerXdeviceEntityPK.class)
public class CustomerXdeviceEntity {


    @Basic
    @Column(name = "date_installation", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateInstallation;
    @ManyToOne
    @Id
    @Column(name = "uid_device", nullable = false, length = -1)
    @JoinColumn(name = "uid_device", referencedColumnName = "uid_device", nullable = false)
    private DeviceEntity uid_device;
    @ManyToOne
    @Id
    @Column(name = "uid_customer", nullable = false, length = -1)
    @JoinColumn(name = "uid_customer", referencedColumnName = "uid_customer", nullable = false)
    private CustomerEntity uid_customer;
    @ManyToOne
    @JoinColumn(name = "uid_cosumption", referencedColumnName = "uid_cosumption", nullable = false)
    private CosumptionEntity uid_cosumption;

    public CustomerXdeviceEntity (CustomerXdeviceDTO customerXdeviceDTODTO) {
        BeanUtils.copyProperties(customerXdeviceDTODTO,this);
        //generar uid

    }

    public CustomerXdeviceDTO tocustomerxDeviceDTO(){
        CustomerXdeviceDTO customerXdeviceDTO= new CustomerXdeviceDTO();
        BeanUtils.copyProperties(this,customerXdeviceDTO);
        return customerXdeviceDTO;
    }

}
