package com.example.springbootcrudwithangular.service.employee;

import com.example.springbootcrudwithangular.common.constant.SSWConstant;
import com.example.springbootcrudwithangular.common.utils.DateUtils;
import com.example.springbootcrudwithangular.entity.Employee;
import com.example.springbootcrudwithangular.common.exception.EmployeeNotFoundException;
import com.example.springbootcrudwithangular.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee createNewEmployee(Employee employee) {
        employee.setCreateTime(DateUtils.getCurrentTime(SSWConstant.FORMAT_DAY_HOUR, SSWConstant.TIMEZONE_VIETNAM));
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        if (!employee.getId().equals(id) || findEmployeeById(id) == null) {
            throw new EmployeeNotFoundException("Employee by id " + id + " was not found");
        }
        employee.setUpdateTime(DateUtils.getCurrentTime(SSWConstant.FORMAT_DAY_HOUR, SSWConstant.TIMEZONE_VIETNAM));
        return null;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " was not found"));
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
