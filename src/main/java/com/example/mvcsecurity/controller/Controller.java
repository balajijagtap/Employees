package com.example.mvcsecurity.controller;

import com.example.mvcsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;

@SuppressWarnings("ALL")
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

    @PostMapping("/updateEmployee")
    public String updateUser(@RequestParam("newPassword") String newPassword,
                             Principal principal,
                             Model model) {
        String currentUsername = principal.getName();

        try {
            employeeService.updateEmployee(currentUsername, newPassword);
            model.addAttribute("successMessage", 1);
        } catch (Exception e) {
            model.addAttribute("errorMessage", 1);
            System.out.println(e.getMessage());
        }
        return "login";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("username") String username, RedirectAttributes redirectAttributes,
                                 Principal principal){
        try {
            employeeService.deleteEmployee(username);
            redirectAttributes.addFlashAttribute("successMessage", 1);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", 1);
        }

        return "redirect:/listEmployees?username=" + principal.getName();
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestParam("username") String username, Principal principal, RedirectAttributes redirectAttributes){
        try {
            employeeService.addEmployee(username, principal.getName());
            redirectAttributes.addFlashAttribute("successMessage", 1);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", 1);
        }
        return "redirect:/";
    }
}
