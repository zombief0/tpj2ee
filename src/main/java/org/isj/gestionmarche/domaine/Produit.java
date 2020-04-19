package org.isj.gestionmarche.domaine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduit;

    @Column(name = "nom_produit",nullable = false)
    @NotNull
    private String nomProduit;

    @Column(name = "description")
    private String description;

    @Column(name = "qte_produit")
    private int qteProduit;

    @Column
    private double prixUnitaire;
    @ManyToOne
    @JoinColumn(name="id_fournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "produit",cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private List<Ravitaillement> ravitaillements = new ArrayList<>();

    @OneToMany(mappedBy = "produit",cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private List<Vente> ventes = new ArrayList<>();

    public Produit() {
    }

    public Produit(String nomProduit, String description, int qteProduit, double prixUnitaire, Fournisseur fournisseur) {
        this.nomProduit = nomProduit;
        this.description = description;
        this.qteProduit = qteProduit;
        this.prixUnitaire = prixUnitaire;
        this.fournisseur = fournisseur;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQteProduit() {
        return qteProduit;
    }

    public void setQteProduit(int qteProduit) {
        this.qteProduit = qteProduit;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<Ravitaillement> getRavitaillements() {
        return ravitaillements;
    }

    public void setRavitaillements(List<Ravitaillement> ravitaillements) {
        this.ravitaillements = ravitaillements;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
