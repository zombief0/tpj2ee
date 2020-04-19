package org.isj.gestionmarche.domaine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ravitaillement")
public class Ravitaillement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRavitaillment;

    @Column(name = "qte_ravitaillement",nullable = false)
    private int qteRavitaillement;

    private Date dateRavitaillement;
    @ManyToOne
    @JoinColumn(name="id_produit")
    private Produit produit;

    public Ravitaillement() {
    }

    public Ravitaillement(int qteRavitaillement, Produit produit) {
        this.qteRavitaillement = qteRavitaillement;
        this.produit = produit;
    }

    public int getIdRavitaillment() {
        return idRavitaillment;
    }

    public void setIdRavitaillment(int idRavitaillment) {
        this.idRavitaillment = idRavitaillment;
    }

    public int getQteRavitaillement() {
        return qteRavitaillement;
    }

    public void setQteRavitaillement(int qteRavitaillement) {
        this.qteRavitaillement = qteRavitaillement;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Date getDateRavitaillement() {
        return dateRavitaillement;
    }

    public void setDateRavitaillement(Date dateRavitaillement) {
        this.dateRavitaillement = dateRavitaillement;
    }
}
