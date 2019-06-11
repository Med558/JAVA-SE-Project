/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DataAccesObject.ClientDAO;
import DataAccesObject.VoitureDAO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Voiture;

/**
 *
 * @author lenovo
 */
public class VoitureTableModel extends AbstractTableModel {
    private ArrayList<Voiture> voiture ;
    public VoitureTableModel(ArrayList<Voiture> voiture) {
     this.voiture=voiture;
    }
    
    public VoitureTableModel() {
     voiture= new VoitureDAO().getAllVoiture();
    }

    
    @Override
    public int getRowCount() {
        return voiture.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex) {
      case 0: return voiture.get(rowIndex).getId();
      case 1: return voiture.get(rowIndex).getMatricule();
      case 2: return voiture.get(rowIndex).getIdmodel();
      case 3: return voiture.get(rowIndex).getIdMarque();
      case 4: return voiture.get(rowIndex).getIdClient();
      
      default: return "value not found";
    }
    }
    public String getColumnName(int column) {
         switch(column) {
      case 0: return "ID Voiture";
      case 1: return "Matricule";
      case 2: return "ID Model";
      case 3: return "ID Marque";
      case 4: return "ID Client";
     
      
      default: return "value not found";
    }
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }
}
