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
import model.*;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ClientDAO extends MonDAO {

    public ClientDAO() {
        super();
    }

    public static ArrayList<Client> getAllClient() {
        ArrayList<Client> listClients = new ArrayList<>();

        try {
            Connection con = MonDAO.con;

            String sql = " SELECT * FROM client";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ArrayList<Voiture> mesVoitures = new ArrayList<>();
                 PreparedStatement ps = con.prepareStatement("select * from voiture where idClient = ?" );
                        ps.setInt(1, rs.getInt(1));
                        ResultSet rs2 = ps.executeQuery();
                        while(rs2.next()){
                            mesVoitures.add(new Voiture(rs2.getInt(1), rs2.getString(2),rs2.getInt(3),rs2.getInt(4),rs2.getInt(5)));
                        }
    
                Client client = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),mesVoitures);
                listClients.add(client);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        return listClients;
    }

    public boolean addClient(Client c) {
        try{
        String sql = "insert into client values (?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, 0);
        preparedStatement.setString(2, c.getNom());
        preparedStatement.setString(3, c.getPrenom());
        preparedStatement.setString(4, c.getEmail());
        preparedStatement.setDouble(5, c.getTel());
        preparedStatement.executeUpdate();
        
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
    public boolean updateClient(Client c, int i){
        try{
        String sql = "UPDATE client set nom = ?, prenom= ?, email = ?, tel = ? where id= ?" ;
        PreparedStatement prepstmt = con.prepareStatement(sql);
        prepstmt.setString(1, c.getNom());
        prepstmt.setString(2, c.getPrenom());
        prepstmt.setString(3, c.getEmail());
        prepstmt.setDouble(4,  c.getTel());
        prepstmt.setInt(5, i);

        prepstmt.executeUpdate();
        System.out.println("Database updated successfully ");
        }catch(Exception e){System.out.println(e);}
        return true;
    }
    public boolean deleteClient(int i){
        try{
        String sql = "DELETE FROM client WHERE id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, i);
        stm.executeUpdate();
        System.out.println("Delate successfully ");

        }catch(Exception e){
            System.out.println(e);}
        return true;
    }
}
