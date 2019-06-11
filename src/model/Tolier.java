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
public class Tolier extends Ouvrier {
    private int idGarage;

    public Tolier(int idGarage, int id, String nomOuvrier, String loginUtilisateur, String login, String password, int typeUtilisateur) {
        super(id, nomOuvrier, loginUtilisateur, login, password, typeUtilisateur);
        this.idGarage = idGarage;
    }

   

    public int getIdSpecialite() {
        return idGarage;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idGarage = idSpecialite;
    }

    @Override
    public String toString() {
        return super.toString()+" "+idGarage; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
