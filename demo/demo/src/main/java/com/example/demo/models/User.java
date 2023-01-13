package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_user")

public class User {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "password")
    private String Password;

    @ManyToOne
    @JoinColumn(name = "role_Id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Employee employee;

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setPassword(String password){
        this.Password = password;
    }
    public String getPassword(){
        return Password;
    }
    public void setRole(Role role){
        this.role = role;
    }
    public Role getRole(){
        return role;
    }
    public Employee getEmployee(){
        return employee;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }

}
