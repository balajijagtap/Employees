package com.example.mvcsecurity.dao;

import com.example.mvcsecurity.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public class EmployeeRepoImp implements EmployeeRepository{
    private final EntityManager entityManager;

    public EmployeeRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findEmployees(String username) {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e WHERE e.manager=:username AND e.manager IS NOT NULL", Employee.class);
        typedQuery.setParameter("username", username);
        return typedQuery.getResultList();
    }

    @Override
    @Modifying
    @Transactional
    public void updateEmployee(String currentUsername, String newPassword) {
        Employee employee = findEmployee(currentUsername);
        employee.setPassword("{noop}"+newPassword);
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(String username) {
        Employee employee = findEmployee(username);
        entityManager.remove(employee);
    }

    @Override
    @Transactional
    public void addEmployee(String username, String manager) {
        Employee employee = new Employee(username, "{noop}"+username, "ROLE_EMPLOYEE", manager, 1);
        entityManager.persist(employee);
    }

    private Employee findEmployee(String username) {
        return entityManager.find(Employee.class, username);
    }
}