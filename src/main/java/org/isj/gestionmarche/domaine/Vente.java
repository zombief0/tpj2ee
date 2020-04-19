package org.isj.gestionmarche.domaine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vente")
public class Vente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVente;

    @Column(name = "qte_vente",nullable = false)
    private int qteVente;

    private Date dateVente;

    @ManyToOne
    @JoinColumn(name="id_produit")
    private Produit produit;

    public Vente() {
    }

    public Vente(int qteVente, Produit produit) {
        this.qteVente = qteVente;
        this.produit = produit;
    }

    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
    }

    public int getQteVente() {
        return qteVente;
    }

    public void setQteVente(int qteVente) {
        this.qteVente = qteVente;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }
}
