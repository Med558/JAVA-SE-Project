/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class Intervention {
    private int id;
    private int idClient;
    private int idVoiture;
    private String dateIntervention;
    private String etat;
    private String description;
    private String serviceConsavre;

    public Intervention(int id, int idClient, int idVoiture, String dateIntervention, String etat, String description, String serviceConsavre) {
        this.id = id;
        this.idClient = idClient;
        this.idVoiture = idVoiture;
        this.dateIntervention = dateIntervention;
        this.etat = etat;
        this.description = description;
        this.serviceConsavre = serviceConsavre;
    }

    public String getDescription() {
        return description;
    }

    public String getServiceConsavre() {
        return serviceConsavre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setServiceConsavre(String serviceConsavre) {
        this.serviceConsavre = serviceConsavre;
    }


    
    

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdVoiture() {
        return idVoiture;
    }

    public String getDateIntervention() {
        return dateIntervention;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public void setDateIntervention(String dateIntervention) {
        this.dateIntervention = dateIntervention;
    }

    @Override
    public String toString() {
        return  id + " " + idClient + " " + idVoiture + " " + dateIntervention + " " + etat + " " + description + " " + serviceConsavre ;
    }
    
    
    
}
