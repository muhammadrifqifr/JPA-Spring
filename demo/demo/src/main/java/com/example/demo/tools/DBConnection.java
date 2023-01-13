package com.example.demo.tools;

import java.sql.DriverManager; 
import java.sql.Connection;

public class DBConnection {
    private static Connection con;
        public static Connection getConnection(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // register driver yang akan digunakan
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_jdbctest", "root", "amartekrifqi");
            } catch (Exception e){
                System.out.println("Error + " + e.getMessage());
            }
            return con;    
        }
}
