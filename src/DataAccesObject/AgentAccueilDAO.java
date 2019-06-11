/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AgentAccueil;
import model.Client;
import model.Ouvrier;
import model.Utilisateur;
import model.Voiture;

/**
 *
 * @author lenovo
 */
public class AgentAccueilDAO extends MonDAO {

    public AgentAccueilDAO() {
        super();
    }

    public ArrayList<AgentAccueil> getAllAgentAcceuil() {
        ArrayList<AgentAccueil> listAgentAcceuil = new ArrayList<>();

        try {
            Connection con = MonDAO.con;

            ArrayList<Utilisateur> listUtilisateur = new UtilisateurDAO().getAllUtilisateurByIdType(4);
            for (Utilisateur utilisateur : listUtilisateur) {
               System.out.println(utilisateur);
                Ouvrier ouvrier = new OuvrierDAO().getOuvrierById(utilisateur.getLogin());
                System.out.println(ouvrier);
                PreparedStatement ps = con.prepareStatement("select * from agentaccueil where idOuvrier = ?");
                System.out.println(ouvrier.getId());
                ps.setInt(1, ouvrier.getId());
                ResultSet rs = ps.executeQuery();
                rs.next();
                listAgentAcceuil.add(new AgentAccueil(rs.getInt(1), rs.getInt(2), ouvrier.getNomOuvrier(), utilisateur.getLogin(), utilisateur.getLogin(), utilisateur.getPassword(), utilisateur.getTypeUtilisateur()));

            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        System.out.println(listAgentAcceuil);

        return listAgentAcceuil;
    }

}
