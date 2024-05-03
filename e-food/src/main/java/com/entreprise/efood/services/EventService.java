package com.entreprise.efood.services;

import java.util.List;

import com.entreprise.efood.dtos.EventDTO;

public interface EventService {

   public List<EventDTO> getEventsByRestaurant(String id);
   public void createEvent(EventDTO eventDTO);
    
} 