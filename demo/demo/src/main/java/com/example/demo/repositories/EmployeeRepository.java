package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query
    (value = "SELECT e.id FROM tb_m_employee e WHERE e.email =?1", nativeQuery = true)
    public Integer findIdByEmail(String email);

    @Query
    (value = "SELECT e.email, u.password FROM tb_m_employee e JOIN tb_m_user u ON e.id = u.id WHERE e.email =?1 && u.password =?2", nativeQuery = true)
    public String findEmailNPass(String email, String password);
}
