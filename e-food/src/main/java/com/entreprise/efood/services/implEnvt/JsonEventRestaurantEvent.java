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
        Long id_resto = Long.parseLong(id);

        return evenementRepository.getEventsByRestaurant(id_resto);
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

    @Override
    public Evenement deleteEvent(EventDTO eventDTO) {

        Evenement eventDeleted = new Evenement();

        eventDeleted.setId(eventDTO.getCode());

        evenementRepository.deleteEventByCodeAndRestaurantId(eventDTO.getCode(), eventDTO.getId_restaurant());

        // evenementRepository.deleteById(eventDeleted.getId());

        return eventDeleted;
    }

    @Override
    public void updateEvent(EventDTO eventDTO) {
        // TODO Auto-generated method stub
        // Evenement eventUpdated = new Evenement();

        // Restaurant restaurant = new Restaurant(eventDTO.getId_restaurant());

        // eventUpdated.setId(eventDTO.getCode());
        // eventUpdated.setDate_debut(eventDTO.getDate_debut());
        // eventUpdated.setDate_fin(eventDTO.getDate_fin());
        // eventUpdated.setTitre(eventDTO.getTitre());
        // eventUpdated.setDescription(eventDTO.getDescription());
        // eventUpdated.setRestaurant(restaurant);

        // evenementRepository.save(eventUpdated);

        evenementRepository.updateEventByCodeAndRestaurantId(eventDTO.getTitre(), eventDTO.getDate_fin(),
                eventDTO.getDate_debut(), eventDTO.getDescription(), eventDTO.getCode(), eventDTO.getId_restaurant());
    }

}
