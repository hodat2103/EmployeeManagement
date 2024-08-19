package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.ResponseObject;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.StatusCode;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getAll/{quantity}")
    public ResponseEntity<?> getAllEmployees(@PathVariable int quantity){
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), employeeService.getAllEmployees(quantity)));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> searchEmployeeById(@PathVariable Integer id){
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), employeeService.searchEmployeeById(id)));
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody  EmployeeDto employeeDto){
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.CREATED.getCode(), StatusCode.CREATED.getMessage(), employeeService.create(employeeDto)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), employeeService.update(id, employeeDto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), employeeService.delete(id)));
    }
    @GetMapping("/export-excel/{quantity}")
    public ResponseEntity<?> exportExcel(HttpServletResponse response,@PathVariable int quantity) throws IOException{
        return ResponseEntity.ok(employeeService.exportExcel(response, quantity));
    }

}
