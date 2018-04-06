package com.example.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class    Employee {
    @Id
    @GeneratedValue
    private int empId;
    private String empName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="empId",referencedColumnName = "empId")
    private List<Attendance> attendanceList;

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public Employee() {
    }
    public Employee(String empName)
    {
        this.empName=empName;
    }
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
