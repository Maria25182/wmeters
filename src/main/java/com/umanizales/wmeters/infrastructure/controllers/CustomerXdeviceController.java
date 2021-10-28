package com.umanizales.wmeters.infrastructure.controllers;

import com.umanizales.wmeters.application.CustomerImp;
import com.umanizales.wmeters.application.CustomerXdeviceImp;
import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.domain.CustomerXdeviceDTO;
import com.umanizales.wmeters.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(path="/CustomerXdevice")
public class CustomerXdeviceController {
    @Autowired
    private CustomerXdeviceImp customerXdeviceImp;
    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CustomerXdeviceDTO customerXdeviceDTO){
        return new ResponseEntity<>(new ResponseDTO("Success",customerXdeviceImp.save(customerXdeviceDTO),null), HttpStatus.OK);
    }
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", customerXdeviceImp. list(),null),
                HttpStatus.OK);
    }
}
