package com.example.demo.models;

import javax.persistence.*;
//import javax.persistence.GenerationType;

@Entity
@Table(name = "tb_m_region")
public class Region {

   
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //@OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    //@JoinColumn(name = "reg_div", JoinColumn = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))

    private Integer id;
    private String name;
    @Column(name = "name")

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
}
