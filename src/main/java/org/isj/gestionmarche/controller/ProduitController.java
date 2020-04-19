package org.isj.gestionmarche.controller;

import org.isj.gestionmarche.domaine.Fournisseur;
import org.isj.gestionmarche.domaine.Produit;
import org.isj.gestionmarche.domaine.Ravitaillement;
import org.isj.gestionmarche.domaine.Vente;
import org.isj.gestionmarche.repositories.FournisseurRepository;
import org.isj.gestionmarche.repositories.ProduitRepository;
import org.isj.gestionmarche.repositories.RavitaillementRepository;
import org.isj.gestionmarche.repositories.VenteRepository;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProduitController {

    private ProduitRepository produitRepository;
    private FournisseurRepository fournisseurRepository;
    private RavitaillementRepository ravitaillementRepository;
    private VenteRepository venteRepository;

    public ProduitController(ProduitRepository produitRepository, FournisseurRepository fournisseurRepository, RavitaillementRepository ravitaillementRepository, VenteRepository venteRepository) {
        this.produitRepository = produitRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.ravitaillementRepository = ravitaillementRepository;
        this.venteRepository = venteRepository;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public String listProduit(Model model){
        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produits",produitList);
        return "index";
    }

    @GetMapping("/produit/add-produit")
    public String ajoutProduit(Model model){
        Produit produit = new Produit();
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        model.addAttribute("produit",produit);
        model.addAttribute("fournisseurs",fournisseurs);
        return "enregistrerProduit";
    }

    @PostMapping("/produit/enregistrer")
    public String enregistrerProduit(@Valid Produit produit, BindingResult result,Model model){
        if(result.hasErrors()){
            return "enregistrerProduit";
        }

        produitRepository.save(produit);
        return "redirect:/";
    }

    @GetMapping("/produit/modifier/{id}")
    public String modifierProduit(@PathVariable int id, Model model){
        Produit produit = produitRepository.findByIdProduit(id);
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        model.addAttribute("produit",produit);
        model.addAttribute("fournisseurs",fournisseurs);
        return "modifierProduit";
    }

    @GetMapping("/produit/details/{id}")
    public String voirDetails(@PathVariable int id, Model model){
        Produit produit = produitRepository.findByIdProduit(id);
        Vente vente = new Vente();
        Ravitaillement ravitaillement = new Ravitaillement();
        List<Ravitaillement> ravitaillements = ravitaillementRepository.findAllByProduit(produit);
        List<Vente> ventes = venteRepository.findAllByProduit(produit);
        model.addAttribute("ravitaillements",ravitaillements);
        model.addAttribute("ventes",ventes);
        model.addAttribute("produit",produit);
        model.addAttribute("vente",vente);
        model.addAttribute("ravitaillement",ravitaillement);
        return "detailsProduit";
    }

    @PostMapping("/produit/update/{id}")
    public String updateProduit(@PathVariable int id,
                                @Valid Produit produit, BindingResult result,Model model){

        produit.setIdProduit(id);
        if(result.hasErrors()){
            return "modifierProduit";
        }

        produitRepository.save(produit);
        return "redirect:/";
    }

    @GetMapping("/produit/delete/{id}")
    public String deleteProduit(@PathVariable int id){
        produitRepository.deleteById(id);
        return "redirect:/";
    }
}
