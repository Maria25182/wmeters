package com.umanizales.wmeters.infrastructure.adapters;

import com.umanizales.wmeters.application.DeviceAble;
import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.domain.DeviceDTO;
import com.umanizales.wmeters.exception.WmeterException;
import com.umanizales.wmeters.infrastructure.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Qualifier("PostgresDeviceRepository")
@Repository("devicePersistence")
public class PostgresDeviceRepository implements DeviceAble {
    @Autowired
    private DeviceRepository deviceRepository;
    @Override
    public DeviceDTO save(DeviceDTO DeviceDTO) {
        return  deviceRepository.save(new DeviceEntity(DeviceDTO)).todeviceDTO();
    }

    @Override
    public boolean update(String code,DeviceDTO DeviceDTO) {
        return deviceRepository.update(new DeviceEntity(DeviceDTO),code)>=1;
    }

    @Override
    public boolean delete(String code)throws WmeterException {
        if(deviceRepository.existsById(code)) {
            try {
                deviceRepository.deleteById(code);
                return true;
            }catch (Exception e){
                throw  new WmeterException("El codigo no se puede eliminar, posee relaciones " +e);
            }
        }else{
            throw new WmeterException("El codigo a borrar no existe" + code);
        }
    }

    @Override
    public List<DeviceDTO> list() {
;
        List<DeviceDTO> deviceDTOS= new ArrayList<>();
       deviceRepository.getDevice().forEach(cos -> deviceDTOS.add(cos.todeviceDTO()));
        return deviceDTOS;
    }

}
