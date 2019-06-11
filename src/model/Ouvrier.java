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
public class Ouvrier extends Utilisateur
{
    private int id;
    private String nomOuvrier;
    private String loginUtilisateur;

    public Ouvrier(int id, String nomOuvrier, String loginUtilisateur, String login, String password, int typeUtilisateur) {
        super(login, password, typeUtilisateur);
        this.id = id;
        this.nomOuvrier = nomOuvrier;
        this.loginUtilisateur = loginUtilisateur;
    }

    


    

    public int getId() {
        return id;
    }

    public String getNomOuvrier() {
        return nomOuvrier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomOuvrier(String nomOuvrier) {
        this.nomOuvrier = nomOuvrier;
    }
    
    @Override
    public String toString() {
        return " Ouvrier{" + "id=" + id + ", nomOuvrier=" + nomOuvrier + ' '+super.toString();
    }
    
}
