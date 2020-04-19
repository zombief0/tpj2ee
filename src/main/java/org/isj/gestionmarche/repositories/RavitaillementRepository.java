package org.isj.gestionmarche.repositories;

import org.isj.gestionmarche.domaine.Produit;
import org.isj.gestionmarche.domaine.Ravitaillement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RavitaillementRepository extends JpaRepository<Ravitaillement,Integer> {

    List<Ravitaillement> findAllByProduit(Produit produit);
}
