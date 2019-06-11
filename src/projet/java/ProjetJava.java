/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.java;

import DataAccesObject.AgentAccueilDAO;
import DataAccesObject.ClientDAO;
import DataAccesObject.MarqueDAO;
import DataAccesObject.OuvrierDAO;
import DataAccesObject.*;
import model.*;
import views.*;

/**
 *
 * @author lenovo
 */
public class ProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ClientDAO cc = new ClientDAO();
        //cc.getAllClient();
        //cc.updateClient(new Client(0,"med","ben hnia","aaaa",458945), 2);
       // cc.deleteClient(7);
        //System.out.println(new MarqueDAO().getAllMarque());
        //new OuvrierDAO().getAllOuvrier();
        //new AgentAccueilDAO().getAllAgentAcceuil();
       // new VoitureDAO().addVoiture(new Voiture(0, "88", 1, 1));
       new Login().setVisible(true);
     // new InterventionDAO().addIntervention(new Intervention(0,1,1,"12/19","en attente","porte","mecano"));
        
    }
    
}
