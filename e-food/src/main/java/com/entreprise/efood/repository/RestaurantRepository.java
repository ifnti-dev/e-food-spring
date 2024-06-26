package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.dtos.RestaurantDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{

    @Query("SELECT new com.entreprise.efood.dtos.RestaurantDTO(r.code, r.nom, r.ville, r.adresse, r.telephone, r.heure_ouverture, r.heure_fermeture, r.jour_ouverture , r.etat,r.coordonnee_gps_x,r.coordonnee_gps_y,r.photoProfil) FROM Restaurant r ")
    public List<RestaurantDTO> getAllRestaurants();

}


  
  