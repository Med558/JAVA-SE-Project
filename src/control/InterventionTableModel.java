/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DataAccesObject.InterventionDAO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Intervention;

/**
 *
 * @author lenovo
 */
public class InterventionTableModel extends AbstractTableModel {
private ArrayList<Intervention> interventions ;
   
public InterventionTableModel(ArrayList<Intervention> interventions) {
     this.interventions=interventions;
    }
    
public InterventionTableModel() {
     interventions= new InterventionDAO().getAllIntervention();
    }
public InterventionTableModel(String service) {
     interventions= new InterventionDAO().getInterventionByService(service);
    }
    
    @Override
    public int getRowCount() {
        return interventions.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex) {
      case 0: return interventions.get(rowIndex).getId();
      case 1: return interventions.get(rowIndex).getIdClient();
      case 2: return interventions.get(rowIndex).getIdVoiture();
      case 3: return interventions.get(rowIndex).getDateIntervention();
      case 4: return interventions.get(rowIndex).getEtat();
      case 5: return interventions.get(rowIndex).getDescription();
      case 6: return interventions.get(rowIndex).getServiceConsavre();
      
      default: return "value not found";
    }
    }
    public String getColumnName(int column) {
         switch(column) {
      case 0: return "ID";
      case 1: return "ID Client";
      case 2: return "ID Voiture";
      case 3: return "Date Intervention";
      case 4: return "Etat";
      case 5: return "Description";
      case 6: return "Service de réparation";
      
      default: return "value not found";
    }
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
