package com.example.mvcsecurity.service;

import com.example.mvcsecurity.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployees(String username);
}
