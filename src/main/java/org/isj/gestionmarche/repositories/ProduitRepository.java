package org.isj.gestionmarche.repositories;

import org.isj.gestionmarche.domaine.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    Produit findByIdProduit(int id);
}
