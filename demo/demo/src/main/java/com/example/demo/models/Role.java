package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_role")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "level")
    private Integer Level;

    public Integer getId(){
        return Id;
    }
    public void setId(Integer id){
        this.Id = id;
    }
    public String getName(){
        return Name;
    }
    public void setName(String name){
        this.Name = name;
    }
    public Integer getLevel(){
        return Level;
    }
    public void setLevel(Integer level){
        this.Level = level;
    }
}
