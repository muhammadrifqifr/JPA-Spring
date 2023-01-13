package com.example.demo.models;

import java.sql.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_m_employee")
public class Employee {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
   
    @Column(name = "email")
    private String Email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthdate")
    private Date BirthDate;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private User user;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String email){
        this.Email = email;
    }
    public Date getBirthdate(){
        return BirthDate;
    }
    public void setBirthdate(Date birthdate){
        this.BirthDate = birthdate;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }
}
