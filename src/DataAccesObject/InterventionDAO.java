/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import static DataAccesObject.MonDAO.con;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author lenovo
 */
public class InterventionDAO extends MonDAO {

    private  ArrayList<Intervention>  listIntervention;
    public InterventionDAO() {
        super();
        listIntervention = getAllIntervention();
    }
    public ArrayList<Intervention> getAllIntervention() {
        ArrayList<Intervention> listIntervention = new ArrayList<>();

        try {
            Connection con = MonDAO.con;

            String sql = " SELECT * FROM intervention";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Intervention intervention = new Intervention(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                listIntervention.add(intervention);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        System.out.println(listIntervention);
        return listIntervention;
    }

    public boolean addIntervention(Intervention i) {
        try{
        String sql = "insert into intervention values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, i.getId());
        preparedStatement.setInt(2, i.getIdClient());
        preparedStatement.setInt(3, i.getIdVoiture());
        preparedStatement.setString(4,  i.getDateIntervention());
        preparedStatement.setString(5,  i.getEtat());
        preparedStatement.setString(6,  i.getDescription());
        preparedStatement.setString(7,  i.getServiceConsavre());
        

        preparedStatement.executeUpdate();
        
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
    public boolean updateIntervention(Intervention i, int id){
        try{
        String sql = "UPDATE intervention set id = ?, idClient= ?, idVoiture = ?, dateintervention = ?, etat= ?,description = ? ,serviceConsavre =? where id=?" ;
        PreparedStatement prepstmt = con.prepareStatement(sql);
        prepstmt.setInt(1, i.getId());
        prepstmt.setInt(2, i.getIdClient());
        prepstmt.setInt(3, i.getIdVoiture());
        prepstmt.setString(4,  i.getDateIntervention());
        prepstmt.setString(5,  i.getEtat());
        prepstmt.setString(6,  i.getDescription());
        prepstmt.setString(7,  i.getServiceConsavre());
        prepstmt.setInt(8,id);

        prepstmt.executeUpdate();
        System.out.println("Database updated successfully ");
        }catch(Exception e){System.out.println(e);}
        return true;
    }
    public boolean deleteIntervention(int id){
        try{
        String sql = "DELETE FROM intervention WHERE id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();
        System.out.println("Delate successfully ");

        }catch(Exception e){
            System.out.println(e);}
        return true;
    }
    
    public ArrayList<Intervention> getInterventionByEtat(String etat){
        int i=0;
        ArrayList<Intervention> interventionEtat = new ArrayList<>();
        while (i<listIntervention.size()) {            
            if (listIntervention.get(i).getEtat().equals(etat)) {
                interventionEtat.add(listIntervention.get(i));
            }
            i++;
        }
        return interventionEtat;
        
    } 
    public ArrayList<Intervention> getInterventionByService(String service){
        int i=0;
        System.out.println(service);
        ArrayList<Intervention> interventionEtat = new ArrayList<>();
        while (i<listIntervention.size()) {     
            
            if (listIntervention.get(i).getServiceConsavre().equals(service)) {
                interventionEtat.add(listIntervention.get(i));
            }
            i++;
        }
        return interventionEtat;
        
    } 
    
    public ArrayList<Intervention> getInterventionContainsChars(String findchars){
         
    int i;
     ArrayList<Intervention> ret=new ArrayList<>();
    
     for( i=0;i<listIntervention.size();i++)
        {
      String c=listIntervention.get(i).toString();
      if(c.contains(findchars)||(findchars.equals("")))
        {ret.add(listIntervention.get(i));}
      
       }
        return ret;
 }

}
