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
public class Model {
    private int id;
    private String libelle;
    private String refference;
    private int idMarque;

    public Model(int id, String libelle, String refference,int idMarque) {
        this.id = id;
        this.libelle = libelle;
        this.refference = refference;
        this.idMarque = idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getRefference() {
        return refference;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setRefference(String refference) {
        this.refference = refference;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    
}
