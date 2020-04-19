package org.isj.gestionmarche.domaine;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUtilisateur;

    @Column(name = "login",unique = true,nullable = false)
    private String login;
    @Column(name = "mdp",nullable = false)
    private String mdp;


    public Utilisateur() {
    }


    public Utilisateur(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }


    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
