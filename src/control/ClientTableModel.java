
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DataAccesObject.ClientDAO;
import DataAccesObject.InterventionDAO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.*;

/**
 *
 * @author lenovo
 */
public class ClientTableModel extends AbstractTableModel {
private ArrayList<Client> clients ;
   
public ClientTableModel(ArrayList<Client> clients) {
     this.clients=clients;
    }
    
public ClientTableModel() {
     clients= new ClientDAO().getAllClient();
    }

    
    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex) {
      case 0: return clients.get(rowIndex).getId();
      case 1: return clients.get(rowIndex).getNom();
      case 2: return clients.get(rowIndex).getPrenom();
      case 3: return clients.get(rowIndex).getEmail();
      case 4: return clients.get(rowIndex).getTel();
      
      default: return "value not found";
    }
    }
    public String getColumnName(int column) {
         switch(column) {
      case 0: return "ID Client";
      case 1: return "Nom";
      case 2: return "Prenom";
      case 3: return "Email";
      case 4: return "Tel";
     
      
      default: return "value not found";
    }
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
