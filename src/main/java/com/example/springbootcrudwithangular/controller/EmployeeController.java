package com.example.springbootcrudwithangular.controller;

import com.example.springbootcrudwithangular.common.constant.SSWConstant;
import com.example.springbootcrudwithangular.entity.Employee;
import com.example.springbootcrudwithangular.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(SSWConstant.REST_URL + "employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/find-all")
    public ResponseEntity<List<Employee>> findAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-id")
    public ResponseEntity<Employee> findEmployeeById(@RequestParam Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.createNewEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @RequestParam Long id) {
        Employee updateEmployee = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
}
