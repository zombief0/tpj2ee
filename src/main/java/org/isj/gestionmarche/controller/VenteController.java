package org.isj.gestionmarche.controller;

import org.isj.gestionmarche.domaine.Produit;
import org.isj.gestionmarche.domaine.Vente;
import org.isj.gestionmarche.repositories.ProduitRepository;
import org.isj.gestionmarche.repositories.VenteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/vente")
public class VenteController {
    public VenteRepository venteRepository;
    public ProduitRepository produitRepository;

    public VenteController(VenteRepository venteRepository, ProduitRepository produitRepository) {
        this.venteRepository = venteRepository;
        this.produitRepository = produitRepository;
    }

    @PostMapping("/saveVente/{idProduit}")
    public String saveVente(@PathVariable int idProduit, @Valid Vente vente){
        Produit produit = produitRepository.findByIdProduit(idProduit);
        vente.setProduit(produit);
        if(vente.getQteVente() < produit.getQteProduit() && vente.getQteVente() >=0) {
            produit.setQteProduit(produit.getQteProduit() - vente.getQteVente());
            vente.setDateVente(new Date());
            produitRepository.save(produit);
            venteRepository.save(vente);
        }
        return "redirect:/produit/details/" + idProduit;
    }
}
