package com.example.demo.controller;

import com.example.demo.dto.DistrictDto;
import com.example.demo.exception.ResponseObject;
import com.example.demo.service.DistrictService;
import com.example.demo.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping()
    public ResponseEntity<?> getAllDistricts(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),districtService.getAllDistricts()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistrictById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.CREATED.getCode(), StatusCode.CREATED.getMessage(), districtService.getDistrictById(id)));
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody DistrictDto districtDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), districtService.create(districtDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DistrictDto districtDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), districtService.update(id, districtDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), districtService.delete(id)));
    }
}
