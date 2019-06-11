/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenovo
 */
public class Voiture {
    private int id;
    private String matricule;
    private int idMarque;
    private int Idmodel;
     private int IdClient;

    public Voiture(int id, String matricule, int idMarque, int Idmodel, int IdClient) {
        this.id = id;
        this.matricule = matricule;
        this.idMarque = idMarque;
        this.Idmodel = Idmodel;
        this.IdClient = IdClient;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int IdClient) {
        this.IdClient = IdClient;
    }
    
  

   

    public String getMatricule() {
        return matricule;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public int getIdmodel() {
        return Idmodel;
    }
    
    public int getId() {
        return id;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setIdMarque(int marque) {
        this.idMarque = marque;
    }

    public void setIdmodel(int Idmodel) {
        this.Idmodel = Idmodel;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Voiture{" + "id=" + id + ", matricule=" + matricule + ", idMarque=" + idMarque + ", Idmodel=" + Idmodel + '}';
    }

   
    
}
