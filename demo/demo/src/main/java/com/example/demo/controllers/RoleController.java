package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.models.Role;
import com.example.demo.services.RoleService;


@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // GET ALL
    @GetMapping
    public String index(Model model){
        model.addAttribute("roles", roleService.getAll());
        return "role/index";
    }

    //CREATE
    //GET
    @GetMapping(value = {"form", "form/{id}"})
    public String getById(@PathVariable(required = false) Integer id, Model model){
        if (id != null){
            model.addAttribute("role", roleService.getById(id));
        } else {
            model.addAttribute("role", new Role());
        }
        return "role/form";
    }

    //POST
    @PostMapping("save")
    public String save(@Nullable Role role){
        Boolean result; 
        if(role.getId() != null){
            result = roleService.save(role);
        } else {
            result = roleService.save(role);
        }
        if (result){
            return "redirect:/role";
        } else {
            return "role/form";
        }
    }

 //DELETE
    //POST
    @PostMapping(value = {"delete/{id}"})
    public String delete(@PathVariable(required = false) Integer id){
        roleService.delete(id);
        return "redirect:/role";
    }
}
