package com.example.demo.controller;

import com.example.demo.dto.CommuneDto;
import com.example.demo.dto.DistrictDto;
import com.example.demo.exception.ResponseObject;
import com.example.demo.service.CommuneService;
import com.example.demo.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/commune")
public class CommuneController {
    @Autowired
    private CommuneService communeService;

    @GetMapping()
    public ResponseEntity<?> getAllCommunes(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),communeService.getAllCommunes()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommuneById(@PathVariable  Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),communeService.getCommuneById(id)));
    }
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CommuneDto communeDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.CREATED.getCode(), StatusCode.CREATED.getMessage(), communeService.create(communeDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CommuneDto communeDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), communeService.update(id, communeDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), communeService.delete(id)));
    }
}
