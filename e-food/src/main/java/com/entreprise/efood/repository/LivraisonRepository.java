package com.entreprise.efood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Livraison;
import com.entreprise.efood.dtos.commandeDTO.LivraisonDTO;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long>{

    @Query("SELECT new com.entreprise.efood.dtos.commandeDTO.LivraisonDTO(liv.description,liv.coordonnee_x,liv.coordonnee_y) FROM Livraison liv WHERE liv.commande.id = :id")
    LivraisonDTO findCommandLivraison(@Param("id") Long id);

}
