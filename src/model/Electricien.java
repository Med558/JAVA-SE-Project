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
public class Electricien extends Ouvrier {
    private int idSpecialite;

    public Electricien(int idSpecialite, int id, String nomOuvrier, String loginUtilisateur, String login, String password, int typeUtilisateur) {
        super(id, nomOuvrier, loginUtilisateur, login, password, typeUtilisateur);
        this.idSpecialite = idSpecialite;
    }

    

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    @Override
    public String toString() {
        return super.toString()+" "+idSpecialite; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
