package com.example.demo.dto.search;

import com.example.demo.domain.Employee;

public class EmployeeSearchDto {
    private String code;
    private String name;
    private String email;
    private String phone;
    private int age;

    public EmployeeSearchDto() {
    }
    public EmployeeSearchDto(Employee employee) {
        this.code = employee.getCode();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.phone = employee.getPhone();
        this.age = employee.getAge();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
