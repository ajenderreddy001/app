package com.example.app.repository;

import com.example.app.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {
}
