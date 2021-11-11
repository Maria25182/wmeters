package com.umanizales.wmeters.infrastructure.controllers;

import com.umanizales.wmeters.application.CosumptionImp;
import com.umanizales.wmeters.domain.CosumptionDTO;
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
@RequestMapping(path="/consumption")
public class CosumptionController {
    @Autowired
    private CosumptionImp cosumptionImp;
    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CosumptionDTO cosumptionDTO){
    return new ResponseEntity<>(new ResponseDTO("Success",cosumptionImp.save(cosumptionDTO),null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", cosumptionImp. list(),null),
                HttpStatus.OK);
    }
    //update
    @PutMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>updateCosumption(@PathVariable String code
                                                                    ,@RequestBody @Valid CosumptionDTO cosumptionDTO)throws WmeterException {
        return new ResponseEntity<>(new ResponseDTO("Success",cosumptionImp.update(code,cosumptionDTO),null), HttpStatus.OK);
    }
        // delete
    @DeleteMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>deleteCosumption(@PathVariable String code)throws WmeterException {
        return  new ResponseEntity<>(new ResponseDTO("success",cosumptionImp.delete(code),null),
                HttpStatus.OK);
    }



}
