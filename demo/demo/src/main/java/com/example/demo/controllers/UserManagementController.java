package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Employee;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("UserManagement")
public class UserManagementController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    //CREATE Bagian Register
    //GET
    @GetMapping(value = {"register"})
    public String create(Model model){
            model.addAttribute("employee", new Employee());
            model.addAttribute("user", new User());
        return "UserManagement/register";
    }

    //POST
    @PostMapping("save")
    public String save(User user, Employee employee){
        Boolean result, result1;
        user.setId(employeeService.findIdByEmail(employee.getEmail()));
        result = employeeService.save(employee);
        Role role = new Role();
        role.setId(roleService.getLevelById());
        user.setRole(role);
        result1 = userService.save(user);
        if (result && result1){
            return "redirect:/employee";
        } else {
            return "employee/form";
        }
    }

    //CREATE Bagian Login
    //GET
    @GetMapping(value = {"login"})
    public String login(Model model){
            model.addAttribute("employee", new Employee());
            model.addAttribute("user", new User());
        return "UserManagement/login";
    }

    //POST 
    @PostMapping("validation")
    public String validation(User user, Employee employee){
        String validation = employeeService.findEmailNPass(employee.getEmail(), user.getPassword());
        if(validation != null){
            return "UserManagement/dashboard";
        } else {
            return "UserManagement/login";
        }
    }
}
