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
public class Utilisateur {
    private String login;
    private String password;
    private int typeUtilisateur;

    public Utilisateur(String login, String password, int typeUtilisateur) {
        this.login = login;
        this.password = password;
        this.typeUtilisateur = typeUtilisateur;
    }

    
    

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeUtilisateur(int typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "login=" + login + ", password=" + password + ", typeUtilisateur=" + typeUtilisateur + '}';
    }
    
}
