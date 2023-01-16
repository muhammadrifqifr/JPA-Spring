package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
// import com.example.demo.repositories.RoleRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan"));
    }

    @Override
    public Boolean save(Employee employee) {
        employeeRepository.save(employee);
        return employeeRepository.findById(employee.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        employeeRepository.deleteById(id);
        return !employeeRepository.findById(id).isPresent();
    }

    @Override
    public Integer findIdByEmail(String email) {
        return employeeRepository.findIdByEmail(email);
    }

    @Override
    public String findEmailNPass(String email, String password) {
        return employeeRepository.findEmailNPass(email, password);
    }
}
