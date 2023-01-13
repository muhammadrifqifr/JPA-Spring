package com.example.demo.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.*;
import com.example.demo.models.Region;

public class RegionDAO {
    private Connection con;

    public RegionDAO(Connection connection){
        this.con = connection;
    }

    //GetAll
    public List<Region> getAll(){
        List<Region> regions = new ArrayList<>();
        String query = "SELECT id, name FROM tb_m_region"; //query ke db
        try {
            ResultSet resultSet = con.prepareStatement(query).executeQuery();  //method ini akan menghasilkan nilai kembalian berupa objek resultSet. Digunakan untuk mengambil data dari db
            while (resultSet.next()){
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                regions.add(region);
                //System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return regions;
    }

    // Get by ID
    public Region getById(int id){
        String query = "SELECT * FROM tb_m_region WHERE Id = ?";
        Region region = new Region();
         try {
            PreparedStatement prepareStatement  = con.prepareStatement(query);
            prepareStatement.setInt(1,id);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()){
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

    //Insert
    public boolean insert(Region region){
        try {
             PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO tb_m_region(name) VALUES (?)");
             preparedStatement.setString(1, region.getName());
             int temp = preparedStatement.executeUpdate(); 
        //   System.out.println("Insert Data Done!");
             return temp > 0; // jika query berhasil
        } catch (SQLException e){
             e.printStackTrace();
        }
        return false; 
    }

    //Update
    public boolean update(Region region){
        try {
            String query = "UPDATE tb_m_region SET id = ?, name = ? WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, region.getId());
            preparedStatement.setString(2, region.getName());
            preparedStatement.setInt(3, region.getId());
            int temp = preparedStatement.executeUpdate(); 
            return temp > 0;
        } catch (SQLException e){
            e.getMessage();
        }
        return false;
    }

    //Delete
    public boolean delete(Integer Id){
        try {
            String query = "DELETE FROM tb_m_region WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, Id);
            int temp = preparedStatement.executeUpdate(); //DDL statement
            return temp > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
