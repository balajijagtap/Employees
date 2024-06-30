package com.example.mvcsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/LoginPage")
    public String loginPage(){
        return "fancy-login";
    }

    @GetMapping("/leaders")
    public String leaderPage(){
        return "leader-page";
    }

    @GetMapping("/admins")
    public String adminPage(){
        return "admin-page";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
