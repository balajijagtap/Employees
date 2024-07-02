package com.example.mvcsecurity.dao;

import com.example.mvcsecurity.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepoImp implements EmployeeRepository{
    private final EntityManager entityManager;

    public EmployeeRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findEmployees(String username) {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e WHERE e.manager=:username" + " AND e.manager IS NOT NULL", Employee.class);
        typedQuery.setParameter("username", username);
        return typedQuery.getResultList();
    }
}
