package com.example.springbootcrudwithangular.service.employee;

import com.example.springbootcrudwithangular.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee createNewEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    List<Employee> findAllEmployee();
    Employee findEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}
