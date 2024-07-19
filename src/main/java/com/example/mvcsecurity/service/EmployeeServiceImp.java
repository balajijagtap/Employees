package com.example.mvcsecurity.service;

import com.example.mvcsecurity.dao.EmployeeRepository;
import com.example.mvcsecurity.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@SuppressWarnings("ALL")
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

    @Override
    @Transactional
    public void updateEmployee(String currentUsername, String newPassword) {
        employeeRepository.updateEmployee(currentUsername, newPassword);
    }

    @Override
    public void deleteEmployee(String username) {
        employeeRepository.deleteEmployee(username);
    }

    @Override
    public void addEmployee(String username, String manager) {
        employeeRepository.addEmployee(username, manager);
    }
}