package org.isj.gestionmarche.repositories;

import org.isj.gestionmarche.domaine.Produit;
import org.isj.gestionmarche.domaine.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {
    List<Vente> findAllByProduit(Produit produit);

}
