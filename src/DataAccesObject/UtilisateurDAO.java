/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import static DataAccesObject.MonDAO.con;
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
public class UtilisateurDAO extends MonDAO {

    private ArrayList<Utilisateur> listUtlisateur;
    public UtilisateurDAO() {
        super();
        listUtlisateur = getAllUtilisateur();
    }
    public ArrayList<Utilisateur> getAllUtilisateur() {
        ArrayList<Utilisateur> listUtilisateur = new ArrayList<>();

        try {
            Connection con = MonDAO.con;

            String sql = " SELECT * FROM utilisateur";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Utilisateur utilisateur = new Utilisateur(rs.getString(1), rs.getString(2), rs.getInt(3));
                listUtilisateur.add(utilisateur);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        this.listUtlisateur = listUtilisateur;
        return listUtilisateur;
    }

    public boolean addUtilisateur(Utilisateur u) {
        try{
        String sql = "insert into utilisateur values (?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, u.getLogin());
        preparedStatement.setString(2, u.getPassword());
        preparedStatement.setInt(3, u.getTypeUtilisateur());
        preparedStatement.executeUpdate();
        
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
    public boolean updateUtilisateur(Utilisateur u, String login){
        try{
        String sql = "UPDATE utilisateur set login = ?, password= ?, typeUtilisateur = ? where login=?" ;
        PreparedStatement prepstmt = con.prepareStatement(sql);
        prepstmt.setString(1, u.getLogin());
        prepstmt.setString(2, u.getPassword());
        prepstmt.setInt(3, u.getTypeUtilisateur());
        prepstmt.setString(4, login);

        prepstmt.executeUpdate();
        System.out.println("Database updated successfully ");
        }catch(Exception e){System.out.println(e);}
        return true;
    }
    public boolean deleteUtilisateur(String login){
        try{
        String sql = "DELETE FROM utilisateur WHERE login = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, login);
        stm.executeUpdate();
        System.out.println("Delate successfully ");

        }catch(Exception e){
            System.out.println(e);}
        return true;
    }
    public ArrayList<Utilisateur> getAllUtilisateurByIdType(int typeId){
        ArrayList<Utilisateur> utilisateurById = new ArrayList<>();
        for (Utilisateur utilisateur : this.listUtlisateur) {
            if (utilisateur.getTypeUtilisateur() == typeId) {
                utilisateurById.add(utilisateur);
            }
        }
        return utilisateurById;
    }
    
}
