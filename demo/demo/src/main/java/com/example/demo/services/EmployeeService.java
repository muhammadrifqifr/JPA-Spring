package com.example.demo.services;

import java.util.List;
import com.example.demo.models.Employee;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(Integer id);
    public Boolean save(Employee employee);
    public Boolean delete(Integer id);
    public Integer findIdByEmail(String email);
    public String findEmailNPass(String email, String password);
}
