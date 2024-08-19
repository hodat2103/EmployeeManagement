package com.example.demo.controller;

import com.example.demo.dto.CertificateDto;
import com.example.demo.dto.CommuneDto;
import com.example.demo.exception.ResponseObject;
import com.example.demo.service.CertificateService;
import com.example.demo.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/certificate")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;
    @GetMapping()
    public ResponseEntity<?> getAllCertificates(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),certificateService.getAllCertificates()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCertificateById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(),certificateService.getCertificateById(id)));
    }
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CertificateDto certificateDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.CREATED.getCode(), StatusCode.CREATED.getMessage(), certificateService.create(certificateDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CertificateDto certificateDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), certificateService.update(id, certificateDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), certificateService.delete(id)));
    }

}
