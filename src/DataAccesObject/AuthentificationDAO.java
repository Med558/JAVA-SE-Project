/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Utilisateur;

/**
 *
 * @author lenovo
 */
public class AuthentificationDAO extends MonDAO {

    public AuthentificationDAO() {
        super();
    }
    
    public Boolean userAuth(String login,String password) {
        try {
            Connection con = MonDAO.con;

            String sql = " SELECT typeUtilisateur FROM utilisateur where login= '"+login+"' and password = '"+password+"'";

             PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
             rs.next();
             if(rs.getInt(1)==0){return false;}else{return true;}
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        return false ;
    }
    
    public int userType(String login,String password) {
        try {
            Connection con = MonDAO.con;

            String sql = " SELECT typeUtilisateur FROM utilisateur where login= '"+login+"' and password = '"+password+"'";

             PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
             rs.next();
           // System.out.println(rs.getInt(1));
           return rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        
        return 0 ;
    }
    
    
    
    
    
}
