package com.example.demo.controller;

import com.example.demo.dto.ProvinceDto;
import com.example.demo.exception.ResponseObject;
import com.example.demo.service.Impl.ProvinceServiceImpl;
import com.example.demo.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/province")
public class ProvinceController {

    @Autowired
    private ProvinceServiceImpl provinceService;

    @GetMapping()
    public ResponseEntity<?> getAllProvinces(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),provinceService.getAllProvinces()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProvinceById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),provinceService.getProvinceById(id)));
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ProvinceDto provinceDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.CREATED.getCode(), StatusCode.CREATED.getMessage(),provinceService.create(provinceDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ProvinceDto provinceDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),provinceService.update(id, provinceDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),provinceService.delete(id)));
    }
}
