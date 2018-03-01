package com.example.app.controller;

import com.example.app.User;
import com.example.app.model.Attendance;
import com.example.app.model.CompoundKey;
import com.example.app.model.EmployeeDetails;
import com.example.app.repository.AttendanceRepository;
import com.example.app.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    EmployeeDetailsRepository employeeDetailsRepository;
    @Autowired
    AttendanceRepository attendanceRepository;

    //@PostMapping(value = "/verify")
    public boolean verifyPassword(@RequestBody final User user)
    {
        EmployeeDetails employeeDetails=employeeDetailsRepository.findByName(user.name);
        if((employeeDetails)!=null) {
            return new BCryptPasswordEncoder().matches(user.password,employeeDetails.getPassword() );
        }
        else
            return false;
    }
    @PostMapping(value="/login")
   public void Login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        HttpSession httpSession=httpServletRequest.getSession(false);
        if(httpSession==null) {
            String name = httpServletRequest.getParameter("tname");
            String password = httpServletRequest.getParameter("tpass");
            System.out.println(name+password);
            if (name != null && password != null)
            {
                if (verifyPassword(new User(name, password))) {
                    int sid = employeeDetailsRepository.findByName(name).getEmpId();
                    String sname = employeeDetailsRepository.findByName(name).getName();
                    String srole = employeeDetailsRepository.findByName(name).getRole();
                    httpServletRequest.getSession().setAttribute("SID", sid);
                    httpServletRequest.getSession().setAttribute("SNAME", sname);
                    httpServletRequest.getSession().setAttribute("SROLE", srole);
                    httpServletResponse.sendRedirect("/go");
                }
                else {
                    httpServletResponse.sendRedirect("/");
                }
            }
            else
            {
                httpServletResponse.sendRedirect("/");
            }
        }
        else
        {
            httpServletResponse.sendRedirect("/go");
        }
    }
    @GetMapping(value="/view/all/attendance")
    public List<Attendance> viewAll(HttpServletRequest httpServletRequest)
    {
        HttpSession httpSession=httpServletRequest.getSession(false);
        if(httpSession!=null)
        {
            if(httpSession.getAttribute("SROLE").equals("hr"))
            {
                return attendanceRepository.findAll();
            }
        }
        return new ArrayList<>();
    }
    @GetMapping(value = "/getout")
    public boolean logout(HttpServletRequest httpServletRequest)
    {
        System.out.println("IN Logout");
        if(httpServletRequest.getSession(false)!=null)
        {
            System.out.println("LOGGED");
            httpServletRequest.getSession(false).invalidate();
            System.out.println("INVALIDATED");
            return true;
        }
        else {
            System.out.println("NONE LOGGED IN");
            return false;
        }
    }

}
