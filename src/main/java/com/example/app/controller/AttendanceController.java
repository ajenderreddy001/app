package com.example.app.controller;

import com.example.app.model.Attendance;
import com.example.app.model.CompoundKey;
import com.example.app.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AttendanceController {
    @Autowired
    AttendanceRepository attendanceRepository;
     public boolean postAttendance(@RequestBody Attendance attendance)
     {
         try
         {
             attendanceRepository.save(attendance);
         }
         catch (Throwable e)
         {
             e.printStackTrace();
             return false;
         }
         return true;
     }
     @GetMapping(value = "/view/attendance")
     public List<Attendance> getAttendanceById(HttpServletRequest httpServletRequest)
     {
         List<Attendance> idAttendance=null;

         HttpSession httpSession=httpServletRequest.getSession(false);
         if(httpSession!=null) {
             int sid=(int)httpSession.getAttribute("SID");
             idAttendance = new ArrayList<>();
             for (Attendance i : attendanceRepository.findAll()) {
                 if (i.getCompoundKey().getEmpId() == sid) {
                     idAttendance.add(i);
                 }
             }
         }
         return idAttendance;
     }
     @GetMapping(value = "/post/attendance")
    public boolean posttAttendance(HttpServletRequest httpServletRequest,@RequestParam("type") String type)
     {
         HttpSession httpSession=httpServletRequest.getSession(false);

         if(httpSession!=null)
         {
             if(type.charAt(0)=='A'||type.charAt(0)=='L'||type.charAt(0)=='P'||type.charAt(0)=='O') {
                 int sid = (int) httpSession.getAttribute("SID");
                 String sname = (String) httpSession.getAttribute("SNAME");
                 Attendance attendance = new Attendance(new CompoundKey(sid), type.charAt(0));

                 System.out.println(sid + sname + attendance.getType());
                 return postAttendance(attendance);
             }
         }
         return false;
     }
}
