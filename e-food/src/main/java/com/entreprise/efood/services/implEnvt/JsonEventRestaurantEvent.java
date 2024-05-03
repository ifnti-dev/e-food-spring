package com.entreprise.efood.services.implEnvt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Evenement;
import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.dtos.EventDTO;
import com.entreprise.efood.repository.EvenementRepository;
import com.entreprise.efood.services.EventService;

@Service
public class JsonEventRestaurantEvent implements EventService {

    @Autowired
    EvenementRepository evenementRepository;

    @Override
    public List<EventDTO> getEventsByRestaurant(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createEvent(EventDTO eventDTO) {
        // instance de evenement
        Evenement event = new Evenement();
        // Instance de restaurant
        Restaurant restaurant = new Restaurant(eventDTO.getId_restaurant());

        event.setRestaurant(restaurant);
        event.setDescription(eventDTO.getDescription());
        event.setDate_debut(eventDTO.getDate_debut());
        event.setDate_fin(eventDTO.getDate_fin());
        event.setTitre(eventDTO.getTitre());


        evenementRepository.save(event);


    }
    
}
