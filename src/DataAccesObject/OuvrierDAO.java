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
import model.Ouvrier;
import model.Utilisateur;

/**
 *
 * @author lenovo
 */
public class OuvrierDAO extends MonDAO {
    
    private ArrayList<Ouvrier> listOuvrier;
    public OuvrierDAO() {
        super();
        listOuvrier = getAllOuvrier();
    }

    public ArrayList<Ouvrier> getAllOuvrier() {
        ArrayList<Ouvrier> listOuvrier = new ArrayList<>();

        try {
            Connection con = MonDAO.con;

            String sql = " SELECT * FROM ouvrier";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                        PreparedStatement ps = con.prepareStatement("select * from utilisateur where login = ?" );
                        ps.setString(1, rs.getString(3));
                        ResultSet rs2 = ps.executeQuery();
                        rs2.next();
    
                Ouvrier ouvrier = new Ouvrier(rs.getInt(1), rs.getString(2), rs.getString(3), rs2.getString(1), rs2.getString(2),rs2.getInt(3));
                listOuvrier.add(ouvrier);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

       
        return listOuvrier;
    }
    public Ouvrier getOuvrierById(String login){
        int i=0;
        while (i<listOuvrier.size()&&!listOuvrier.get(i).getLogin().equals(login)) {            
            i++;
        }
        if(i<listOuvrier.size())
        return listOuvrier.get(i);
        else
        return new Ouvrier(0, "introuvable", "intouvable", "introuvable", "o", 1);
    }
}
