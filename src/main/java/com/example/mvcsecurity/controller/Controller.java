package com.example.mvcsecurity.controller;

import com.example.mvcsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    private final EmployeeService employeeService;

    @Autowired
    public Controller(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/LoginPage")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/listEmployees")
    public String listEmployees(Model model, @RequestParam("username") String username){
        model.addAttribute("employees", employeeService.findEmployees(username));
        return "list-employees";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
