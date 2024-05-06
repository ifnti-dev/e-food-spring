package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Composant;
import com.entreprise.efood.dtos.ComposantDTO;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ComposantRepository extends JpaRepository<Composant, Long> {

    // requête SQL récupérant l'ensemble des composantes en utilisant le DTO
    // Composant
    @Query("SELECT new com.entreprise.efood.dtos.ComposantDTO(c.id, c.nom, c.prix, c.composition,  c.createdAt, c.updatedAt) from Composant c ")
    public List<ComposantDTO> getComposants();

}
