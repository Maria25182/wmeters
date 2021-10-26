package com.umanizales.wmeters.infrastructure.repositories;

import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.DeviceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "device", schema = "public", catalog = "wmeter")
public class DeviceEntity {
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uidDevice;
    @Id
    @Column(name = "uid_device", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    public DeviceEntity(DeviceDTO deviceDTO) {
        BeanUtils.copyProperties(deviceDTO,this);
        //generar uid
        this.uidDevice = UUID.randomUUID().toString();
    }

    public DeviceDTO todeviceDTO(){
        DeviceDTO deviceDTO= new DeviceDTO();
        BeanUtils.copyProperties(this,deviceDTO);
        return deviceDTO;
    }


}
