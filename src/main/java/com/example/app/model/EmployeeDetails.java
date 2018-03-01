package com.example.app.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
public class EmployeeDetails {
    @Id
    @GeneratedValue
    private int empId;
    private String name;
    private String role;
    @Column(nullable =false )
    private String password;

    public EmployeeDetails() {
    }
    public EmployeeDetails(String name,String password,String role)
    {
        this.name=name;this.password=new BCryptPasswordEncoder().encode(password);
        this.role=role;

    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
