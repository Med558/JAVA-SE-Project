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
public class AgentAccueil extends Ouvrier {
    private int idBureau;

    public AgentAccueil(int idBureau, int id, String nomOuvrier, String loginUtilisateur, String login, String password, int typeUtilisateur) {
        super(id, nomOuvrier, loginUtilisateur, login, password, typeUtilisateur);
        this.idBureau = idBureau;
    }

    

    public int getIdBureau() {
        return idBureau;
    }

    public void setIdBureau(int idBureau) {
        this.idBureau = idBureau;
    }

    @Override
    public String toString() {
        return super.toString()+" "+idBureau; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
