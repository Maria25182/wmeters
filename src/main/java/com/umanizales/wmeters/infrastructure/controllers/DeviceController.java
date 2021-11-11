package com.umanizales.wmeters.infrastructure.controllers;

import com.umanizales.wmeters.application.CosumptionImp;
import com.umanizales.wmeters.application.DeviceImp;
import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.DeviceDTO;
import com.umanizales.wmeters.exception.WmeterException;
import com.umanizales.wmeters.infrastructure.controllers.dto.ResponseDTO;
import com.umanizales.wmeters.infrastructure.repositories.CosumptionEntity;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/device")
public class DeviceController {
    @Autowired
    private DeviceImp deviceImp;
    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid DeviceDTO deviceDTO){
        return new ResponseEntity<>(new ResponseDTO("Success",deviceImp.save(deviceDTO),null), HttpStatus.OK);
    }
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", deviceImp. list(),null),
                HttpStatus.OK);
    }
    @DeleteMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>deleteDevice(@PathVariable String code)throws WmeterException {
        return  new ResponseEntity<>(new ResponseDTO("success",deviceImp.delete(code),null),
                HttpStatus.OK);
    }
    @PutMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>updateDevice(@PathVariable String code
            ,@RequestBody @Valid DeviceDTO deviceDTO)throws WmeterException {
        return new ResponseEntity<>(new ResponseDTO("Success",deviceImp.update(code,deviceDTO),null), HttpStatus.OK);
    }
}
