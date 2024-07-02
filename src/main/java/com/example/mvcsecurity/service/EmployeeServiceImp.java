package com.example.mvcsecurity.service;

import com.example.mvcsecurity.dao.EmployeeRepository;
import com.example.mvcsecurity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    public List<Employee> findEmployees(String username) {
        return employeeRepository.findEmployees(username);
    }
}
