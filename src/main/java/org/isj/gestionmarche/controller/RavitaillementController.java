package org.isj.gestionmarche.controller;

import org.isj.gestionmarche.domaine.Produit;
import org.isj.gestionmarche.domaine.Ravitaillement;
import org.isj.gestionmarche.repositories.ProduitRepository;
import org.isj.gestionmarche.repositories.RavitaillementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/ravitaillement")
public class RavitaillementController {

    private RavitaillementRepository ravitaillementRepository;
    private ProduitRepository produitRepository;

    public RavitaillementController(RavitaillementRepository ravitaillementRepository, ProduitRepository produitRepository) {
        this.ravitaillementRepository = ravitaillementRepository;
        this.produitRepository = produitRepository;
    }

    @PostMapping("/saveRavitaillement/{idProduit}")
    public String saveRavi(@PathVariable int idProduit, @Valid Ravitaillement ravitaillement){
        if(ravitaillement.getQteRavitaillement() >=0){
            Produit produit = produitRepository.findByIdProduit(idProduit);
            ravitaillement.setProduit(produit);
            ravitaillement.setDateRavitaillement(new Date());
            produit.setQteProduit(ravitaillement.getQteRavitaillement() + produit.getQteProduit());
            ravitaillementRepository.save(ravitaillement);
            produitRepository.save(produit);
        }

        return "redirect:/produit/details/" + idProduit;
    }
}
