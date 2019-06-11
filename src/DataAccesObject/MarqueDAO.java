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
public class MarqueDAO extends MonDAO{
    ArrayList<Marque> listMarque;

    public MarqueDAO() {
        super();
        listMarque = getAllMarque();
    }
    
    public ArrayList<Marque> getAllMarque(){
        
        ArrayList<Marque> listMarque = new ArrayList<>();
            try {
            Connection con = MonDAO.con;
            String sql = " SELECT * FROM marque";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                
                sql = "select * from model where idMarque ="+rs.getInt(1);
                PreparedStatement stmt2 = con.prepareStatement(sql);
                ResultSet rs2 = stmt2.executeQuery();
                ArrayList<Model> models=new ArrayList<>();
                while (rs2.next()) {
                    models.add(new Model(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getInt(4)));   
                }
                listMarque.add(new Marque(rs.getInt(1), rs.getNString(2), models));
                
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return listMarque;
    

        
        
    }
    public ArrayList<Model> getAllModelByMarque(String model){
        
       int i = 0;
        while (!listMarque.get(i).getLibelle().equals(model)) {            
            i++;
        }
        return listMarque.get(i).getMesModel();
    }
    public int getMarqueIdByName(String name){
        int i=0;
        while(i<listMarque.size()&&!listMarque.get(i).getLibelle().equals(name)){
            i++;
        }
        return listMarque.get(i).getId();
    }
    public int getModelIdByMarqueNameModelName(String MarqueName,String ModelName){
        int i=0,j=0;
        while(i<listMarque.size()&&!listMarque.get(i).getLibelle().equals(MarqueName)){
            i++;
        }
        while (j<listMarque.get(i).getMesModel().size()&&!listMarque.get(i).getMesModel().get(j).getLibelle().equals(ModelName)) {            
            j++;
        }
        return listMarque.get(i).getMesModel().get(j).getId();
    }
}
