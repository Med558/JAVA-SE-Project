/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Marque {
    private int id;
    private String libelle;
     private ArrayList<Model> mesModel;

    public Marque(int id, String libelle, ArrayList<Model> mesModel) {
        this.id = id;
        this.libelle = libelle;
        this.mesModel = mesModel;
    }

    public Marque() {
        
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public ArrayList<Model> getMesModel() {
        return mesModel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setMesModel(ArrayList<Model> mesModel) {
        this.mesModel = mesModel;
    }

    @Override
    public String toString() {
        return libelle ;
    }
     
    
}
