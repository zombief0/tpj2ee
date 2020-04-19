package org.isj.gestionmarche.domaine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fournisseur")
public class Fournisseur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFournisseur;

    @Column(name = "nom_fournisseur",nullable = false)
    @NotNull
    private String nomFournisseur;

    @Column(name = "localisation",nullable = false)
    @NotNull
    private String localisation;

    @OneToMany(mappedBy = "fournisseur",cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private List<Produit> produits = new ArrayList<>();

    public Fournisseur() {
    }

    public Fournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
