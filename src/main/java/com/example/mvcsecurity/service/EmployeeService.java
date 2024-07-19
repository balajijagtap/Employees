package com.example.mvcsecurity.service;

import com.example.mvcsecurity.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployees(String username);

    void updateEmployee(String currentUsername, String newPassword);

    void deleteEmployee(String username);

    void addEmployee(String username, String manager);
}