package com.entreprise.efood.services.implEnvt;

import java.util.List;

import com.entreprise.efood.Models.Evenement;
import com.entreprise.efood.dtos.EventDTO;

public interface EventService {

   public List<EventDTO> getEventsByRestaurant(String id);
   public void createEvent(EventDTO eventDTO);
   public Evenement deleteEvent(EventDTO eventDTO);
   public void updateEvent(EventDTO eventDTO);
    
} 