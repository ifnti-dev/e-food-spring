package com.entreprise.efood.repository;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.entreprise.efood.Models.Evenement;
import com.entreprise.efood.dtos.EventDTO;



public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    @Query("SELECT new com.entreprise.efood.dtos.EventDTO(event.restaurant.id,event.description,event.date_debut,event.date_fin,event.titre,event.id) FROM Evenement event Where event.restaurant.id=:restaurant_id")
    public List<EventDTO> getEventsByRestaurant(@Param("restaurant_id") Long restaurant_id);

    @Transactional
    @Modifying
    @Query("UPDATE Evenement event SET event.titre=:titre,event.description=:description, event.date_fin=:date_fin,event.date_debut=:date_debut WHERE event.id=:code AND event.restaurant.id=:restaurant_id")
    public void updateEventByCodeAndRestaurantId(@Param("titre") String titre,@Param("date_fin") Timestamp date_fin,@Param("date_debut") Timestamp date_debut,@Param("description") String description,@Param("code") Long code,@Param("restaurant_id") Long restaurant_id);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Evenement event WHERE event.id=:code AND event.restaurant.id=:restaurant_id")
    public void deleteEventByCodeAndRestaurantId(@Param("code") Long code, @Param("restaurant_id") Long restaurant_id);

    long deleteById(long id);

}