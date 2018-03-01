package com.example.app.repository;

import com.example.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmpName(String name);

    Employee findByEmpId(int id);
}
