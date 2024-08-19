package com.example.demo.dto;

import com.example.demo.domain.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {
    private String code;
    private String name;
    private String email;
    private String phone;
    private int age;



    public EmployeeDto(Employee employee) {
        this.code = employee.getCode();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.phone = employee.getPhone();
        this.age = employee.getAge();
    }

}
