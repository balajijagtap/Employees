package com.example.mvcsecurity.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    @Column(name="manager")
    private String manager;

    @Column(name="active")
    private int active;

    public Employee() {
    }

    public Employee(String username, String password, String role, String manager, int active) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.manager = manager;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", manager='" + manager + '\'' +
                ", active=" + active +
                '}';
    }
}
