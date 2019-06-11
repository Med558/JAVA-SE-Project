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
import model.Voiture;

/**
 *
 * @author lenovo
 */
public class VoitureDAO extends MonDAO{
    private ArrayList<Voiture> listVoiture;
    public VoitureDAO() {
        super();
        listVoiture = getAllVoiture();
    }
    public ArrayList<Voiture> getAllVoiture() {
        ArrayList<Voiture> listVoiture = new ArrayList<>();

        try {
            Connection con = MonDAO.con;

            String sql = " SELECT * FROM voiture";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Voiture voiture = new Voiture(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
                listVoiture.add(voiture);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        this.listVoiture = listVoiture;
        return listVoiture;
    }
    
    public boolean addVoiture(Voiture voiture) {
        try{
        String sql = "insert into Voiture values (?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, voiture.getId());
        preparedStatement.setString(2, voiture.getMatricule());
        preparedStatement.setInt(3, voiture.getIdMarque());
        preparedStatement.setInt(4, voiture.getIdmodel());
        preparedStatement.setInt(5, voiture.getIdClient());
        preparedStatement.executeUpdate();
        
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
    public boolean deleteVoiture(int i){
        try{
        String sql = "DELETE FROM voiture WHERE id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, i);
        stm.executeUpdate();
        System.out.println("Delate successfully ");

        }catch(Exception e){
            System.out.println(e);}
        return true;
    }
    
}
