package com.example.app.controller;

import com.example.app.model.Attendance;
import com.example.app.model.CompoundKey;
import com.example.app.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewController {
    @RequestMapping(value = "/")
    public String home(HttpServletRequest httpServletRequest)
    {
        if(httpServletRequest.getSession(false)!=null)
        {
            return "home";
        }
        else
        {
            return "login";
        }
    }
    @RequestMapping(value = "/out")
    public String out(HttpServletRequest httpServletRequest)
    {
        if(httpServletRequest.getSession(false)!=null)
        {
            new LoginController().logout(httpServletRequest);
            return "login";
        }
        else {
            return "login";
        }
    }
    @RequestMapping(value = "/go")
    public String go(HttpServletRequest httpServletRequest)
    {
        if(httpServletRequest.getSession(false)!=null)
        {
            return "home";
        }
        else {
            return "login";
        }
    }


}

