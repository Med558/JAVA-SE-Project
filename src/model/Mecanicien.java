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
public class Mecanicien extends Ouvrier {
    private int idGrade;

    public Mecanicien(int idGrade, int id, String nomOuvrier, String loginUtilisateur, String login, String password, int typeUtilisateur) {
        super(id, nomOuvrier, loginUtilisateur, login, password, typeUtilisateur);
        this.idGrade = idGrade;
    }

    

    public int getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(int idGrade) {
        this.idGrade = idGrade;
    }

    @Override
    public String toString() {
        return super.toString()+" "+idGrade; //To change body of generated methods, choose Tools | Templates.
    }
    
}
