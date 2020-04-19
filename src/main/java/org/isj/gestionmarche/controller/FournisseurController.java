package org.isj.gestionmarche.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.isj.gestionmarche.domaine.Fournisseur;
import org.isj.gestionmarche.repositories.FournisseurRepository;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
    private FournisseurRepository fournisseurRepository;

    public FournisseurController(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
    }

    @GetMapping("/listeFournisseur")
    public String list(Model model){
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        model.addAttribute("fournisseurs",fournisseurList);
        return "fournisseurs";
    }

    @GetMapping("/add-fournisseur")
    public String ajouterFournisseur(Model model){
        Fournisseur fournisseur = new Fournisseur();
        model.addAttribute("fournisseur",fournisseur);
        return "registerFournisseur";
    }

    @PostMapping("/enregistrer")
    public String enregistrerFournisseur(@Valid Fournisseur fournisseur, BindingResult result, Model model){
        if(result.hasErrors()){
            return "registerFournisseur";
        }

        fournisseurRepository.save(fournisseur);
        return "redirect:/fournisseur/listeFournisseur";
    }

    @GetMapping("/modifier/{id}")
    public String modifierFournisseur(@PathVariable int id, Model model){
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseur(id);
        model.addAttribute("fournisseur",fournisseur);
        return "modifierFournisseur";
    }

    @PostMapping("/update/{id}")
    public String updateFournisseur(@PathVariable int id,
                                    @Valid Fournisseur fournisseur,
                                    BindingResult result,Model model){
        fournisseur.setIdFournisseur(id);
        if(result.hasErrors()){
            return "modifierFournisseur";
        }

        fournisseurRepository.save(fournisseur);
        return "redirect:/fournisseur/listeFournisseur";
    }

    @GetMapping("/delete/{id}")
    public String deleteFournisseur(@PathVariable int id){
        fournisseurRepository.deleteById(id);
        return "redirect:/fournisseur/listeFournisseur";
    }
}
