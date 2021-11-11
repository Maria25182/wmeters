package com.umanizales.wmeters.infrastructure.controllers;

import com.umanizales.wmeters.application.CustomerImp;
import com.umanizales.wmeters.application.CustomerXdeviceImp;
import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
import com.umanizales.wmeters.domain.DeviceDTO;
import com.umanizales.wmeters.exception.WmeterException;
import com.umanizales.wmeters.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(path="/Customerxdevice")
public class CustomerXdeviceController {
    @Autowired
    private CustomerXdeviceImp customerxdeviceImp;
    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CustomerXdeviceDTO customerXdeviceDTO){
        return new ResponseEntity<>(new ResponseDTO("Success",customerxdeviceImp.save(customerXdeviceDTO),null), HttpStatus.OK);
    }
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", customerxdeviceImp.list(),null),
                HttpStatus.OK);
    }
    @DeleteMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>deleteCustomerxDevice(@PathVariable String code)throws WmeterException {
        return  new ResponseEntity<>(new ResponseDTO("success",customerxdeviceImp
                .delete(code),null),
                HttpStatus.OK);
    }
    @PutMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>updateCustomerxDevice(@PathVariable String code
            ,@RequestBody @Valid CustomerXdeviceDTO customerXdeviceDTO)throws WmeterException {
        return new ResponseEntity<>(new ResponseDTO("Success",customerxdeviceImp.update(code,customerXdeviceDTO),null), HttpStatus.OK);
    }
}
