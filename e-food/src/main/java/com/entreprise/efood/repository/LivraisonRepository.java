package com.entreprise.efood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Livraison;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long>{

}
