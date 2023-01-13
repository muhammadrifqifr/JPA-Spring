 package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.models.Employee;
import com.example.demo.models.User;
import com.example.demo.models.Role;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.UserService;
import com.example.demo.services.RoleService;


@Controller
@RequestMapping("employee")
public class EmployeeController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;

     // GET ALL
    @GetMapping
    public String index(Model model){
        model.addAttribute("users", userService.getAll());
        return "employee/index";
    }
    //CREATE
    //GET
    @GetMapping(value = {"form"})
    public String create(Model model){
            model.addAttribute("employee", new Employee());
            model.addAttribute("user", new User());
        return "employee/form";
    }

    //POST
    @PostMapping("save")
    public String save(User user, Employee employee){
        Boolean result, result1;
        result = employeeService.save(employee);
        user.setId(employeeService.findIdByEmail(employee.getEmail()));
        Role role = new Role();
        role.setId(roleService.getLevelById());
        user.setRole(role);
        result1 = userService.save(user);
        if (result && result1){
            return "redirect:/employee";
        }else {
            return "employee/form";
        }
    }
    //DELETE
    //POST
    @PostMapping(value = {"delete/{id}"})
    public String delete(@PathVariable Integer id){
        employeeService.delete(id);
        return "redirect:/employee";
    }
}
