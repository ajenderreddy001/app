package com.example.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Embeddable
public class CompoundKey implements Serializable {
    private int empId;
    @Column(nullable = false)
    private String date;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date=datenow();
    }
    public CompoundKey()
    {}
    public CompoundKey(int empId)
    {
        this.empId=empId;
        this.date=datenow();
    }

    static String datenow()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
