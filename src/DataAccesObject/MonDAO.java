/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class MonDAO {
    public static Connection con;

    public MonDAO() {
        String url = "jdbc:mysql://localhost:3306/ateliermecanicien?zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "";

        System.out.println("Connecting database...");

        try {

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    
    
}
