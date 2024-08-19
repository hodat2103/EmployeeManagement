package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.search.EmployeeSearchDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
public interface EmployeeService {
    List<EmployeeDto> getAllEmployees(int quantity);
    EmployeeSearchDto searchEmployeeById(Integer id);

    EmployeeDto create(EmployeeDto employeeDto);
    EmployeeDto update(Integer id, EmployeeDto employeeDto);
    EmployeeDto delete(Integer id);

    Object exportExcel(HttpServletResponse response, int quantity) throws IOException;
    Object importExcel(MultipartFile file) throws IOException;

}
