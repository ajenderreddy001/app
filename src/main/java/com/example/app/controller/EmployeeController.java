package com.example.app.controller;

import com.example.app.User;
import com.example.app.model.Employee;
import com.example.app.model.EmployeeDetails;
import com.example.app.repository.EmployeeDetailsRepository;
import com.example.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeDetailsRepository employeeDetailsRepository;

    //@GetMapping(value = "/all")
    public List<Employee> getAllEmployee()      {

        return employeeRepository.findAll();
    }

    //@GetMapping(value = "/find/{name}")
    public Employee findByEmpName(@PathVariable final String name)
    {
        return employeeRepository.findByEmpName(name);
    }
    public Employee findByEmpId(@RequestParam("ID") final int id)
    {
        return employeeRepository.findByEmpId(id);
    }
    @PostMapping(value="/employee/create")
    public boolean create(@RequestBody User user)
    {
        if(user.password==null||user.name==null)
            return false;
        Employee employee=new Employee(user.name);
        EmployeeDetails employeeDetails=new EmployeeDetails(user.name,user.password,"employee");
        try {
            if(employeeRepository.findByEmpName(employee.getEmpName())!=null)
            {
                return false;
            }
            employeeDetailsRepository.save(employeeDetails);
            employeeRepository.save(employee);
        }
        catch (Throwable e)
        {
            return false;
        }
        return true;
    }

}
