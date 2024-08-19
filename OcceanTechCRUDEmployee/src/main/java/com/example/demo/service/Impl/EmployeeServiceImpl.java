package com.example.demo.service.Impl;

import com.example.demo.domain.Employee;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.export.EmployeeExcelExporter;
import com.example.demo.dto.search.EmployeeSearchDto;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.StatusCode;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees(int quantity) {
        quantity = 0;
        int i = 0;
        List<Employee> employeeList = employeeRepository.getAllEmployees();
        if(employeeList.isEmpty())
         throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee list is empty");
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for(Employee employee : employeeList){
            if(i <= quantity){
                EmployeeDto employeeDto =  new EmployeeDto(employee);
                employeeDtoList.add(employeeDto);
                i++;
            }
        }
        return employeeDtoList;
    }

    @Override
    public EmployeeSearchDto searchEmployeeById(Integer id) {
        Employee employee = employeeRepository.getById(id);
        if(employee == null)
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");

        return new EmployeeSearchDto(employee);
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setCode(employeeDto.getCode());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setAge(employeeDto.getAge());

        employeeRepository.save(employee);
        return new EmployeeDto(employee);
    }

    @Override
    public EmployeeDto update(Integer id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findEmployeeById(id);
        if(employee == null)
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");

        employee.setCode(employeeDto.getCode());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setAge(employeeDto.getAge());

        employeeRepository.save(employee);
        return new EmployeeDto(employee);
    }

    @Override
    public EmployeeDto delete(Integer id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        if(employee == null)
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        employeeRepository.delete(employee);
        return new EmployeeDto(employee);
    }

    @Override
    public Object exportExcel(HttpServletResponse response, int quantity) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "content-Disposition";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormat.format(new Date());
        String filename = "Employees"+ currentDateTime +".xlsx";
        String headerValue = "attachment; filename=" + filename;
        response.setHeader(headerKey,headerValue);
        List<EmployeeDto> listEmployees = getAllEmployees(quantity);

        EmployeeExcelExporter employeeExcelExporter = new EmployeeExcelExporter(listEmployees);
        employeeExcelExporter.export(response);
        return StatusCode.OK.getMessage();
    }

    @Override
    public Object importExcel(MultipartFile file) throws IOException {
        return null;
    }
}
