package com.example.app.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Attendance {

    @Id
    private CompoundKey compoundKey;

    private char type;//L Leave

    public Attendance() {
    }

    public Attendance(CompoundKey compoundKey,char type) {
        this.compoundKey=compoundKey;
        this.type=type;
    }

   /* public String getDate() {
        return date;
    }

    public void setDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDateTime now = LocalDateTime.now();
        date=dtf.format(now);
        this.date = date;
    }*/

    public char getType() {

        return type;
    }

    public void setType(char type) {

        this.type = type;
    }

    public CompoundKey getCompoundKey() {

        return compoundKey;
    }

    public void setCompoundKey(CompoundKey compoundKey) {

        this.compoundKey = compoundKey;
    }
}
