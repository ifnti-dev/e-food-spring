package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.dtos.OrderDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;



@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long>{


    // @Query("SELECT new com.entreprise.efood.dtos.OrderDTO(event.restaurant.id,event.description,event.date_debut,event.date_fin,event.titre,event.id,event.status) FROM Evenement event Where statut=:status")
    public List<Commande> findByEtat( String etat);

}
