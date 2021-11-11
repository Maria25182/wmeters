package com.umanizales.wmeters.infrastructure.controllers;

import com.umanizales.wmeters.application.CosumptionImp;
import com.umanizales.wmeters.application.CustomerImp;
import com.umanizales.wmeters.domain.CosumptionDTO;
import com.umanizales.wmeters.domain.CustomerDTO;
import com.umanizales.wmeters.exception.WmeterException;
import com.umanizales.wmeters.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(path="/customer")
public class CustomerController {
    @Autowired
    private CustomerImp customerImp;
    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CustomerDTO customerDTO){
        return new ResponseEntity<>(new ResponseDTO("Success",customerImp.save(customerDTO),null), HttpStatus.OK);
    }
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", customerImp. list(),null),
                HttpStatus.OK);
    }
    @DeleteMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>deleteCustomer(@PathVariable String code)throws WmeterException {
        return  new ResponseEntity<>(new ResponseDTO("success",customerImp.delete(code),null),
                HttpStatus.OK);
    }
    @PutMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>updateCustomer(@PathVariable String code
            ,@RequestBody @Valid CustomerDTO customerDTO)throws WmeterException {
        return new ResponseEntity<>(new ResponseDTO("Success",customerImp.update(code,customerDTO),null), HttpStatus.OK);
    }
}
