package com.example.mvcsecurity.dao;

import com.example.mvcsecurity.entity.Employee;

import java.util.List;

public interface EmployeeRepository{
    List<Employee> findEmployees(String username);
}
