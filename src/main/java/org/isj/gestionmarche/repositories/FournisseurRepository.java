package org.isj.gestionmarche.repositories;

import org.isj.gestionmarche.domaine.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
    Fournisseur findByIdFournisseur(int id);
}
