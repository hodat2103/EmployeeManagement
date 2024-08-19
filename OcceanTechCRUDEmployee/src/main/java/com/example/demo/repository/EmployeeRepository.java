package com.example.demo.repository;


import com.example.demo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query ("SELECT new com.example.demo.dto.EmployeeDto (ed) FROM Employee  ed")
    List<Employee> getAllEmployees();

    Employee findEmployeeByCode(String code);
    Employee findEmployeeById(Integer id);

}
