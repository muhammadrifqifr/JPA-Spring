package com.example.demo.models;

// import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setRegion(Region region){
        this.region = region;
    }
    public Region getRegion(){
        return region;
    }

}