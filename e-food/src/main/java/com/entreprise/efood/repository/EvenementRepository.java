package com.entreprise.efood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entreprise.efood.Models.Evenement;
import com.entreprise.efood.dtos.EventDTO;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    @Query("SELECT new com.entreprise.efood.dtos.EventDTO(event.restaurant.id,event.description,event.date_debut,event.date_fin,event.titre) FROM Evenement event Where event.restaurant.id=:restaurant_id")
    public List<EventDTO> getEventsByRestaurant(@Param("restaurant_id") Long restaurant_id);
}
