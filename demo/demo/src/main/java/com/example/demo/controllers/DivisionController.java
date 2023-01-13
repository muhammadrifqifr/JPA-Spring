package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.models.Division;
import com.example.demo.services.DivisionService;
import com.example.demo.services.RegionService;


@Controller
@RequestMapping("division")
public class DivisionController {
    
    @Autowired
    private DivisionService divisionService;
    @Autowired 
    private RegionService regionService;
    // GET ALL
    @GetMapping
    public String index(Model model){
        model.addAttribute( "divisions", divisionService.getAll());
        return "division/index";
    }

    //CREATE
    //GET
    @GetMapping(value = {"form", "form/{id}"})
    public String getById(@PathVariable(required = false) Integer id, Model model){
        if (id != null){
            model.addAttribute("division", divisionService.getById(id));
            model.addAttribute("regions", regionService.getAll());
        } else {
            model.addAttribute("division", new Division());
            model.addAttribute("regions", regionService.getAll());
        }
        return "division/form";
    }

    // //POST
    @PostMapping("save")
    public String save(@Nullable Division division){
        Boolean result; 
        if(division.getId() != null){
            result = divisionService.save(division);
        } else {
            result = divisionService.save(division);
        }
        if (result){
            return "redirect:/division";
        } else {
            return "division/form";
        }
    }

    // //DELETE
    // //POST
    @PostMapping(value = {"delete/{id}"})
    public String delete(@PathVariable(required = false) Integer id){
        divisionService.delete(id);
        return "redirect:/division";
    }
}
  

