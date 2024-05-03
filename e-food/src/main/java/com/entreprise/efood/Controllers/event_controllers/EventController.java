package com.entreprise.efood.Controllers.event_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.dtos.EventDTO;
import com.entreprise.efood.services.implEnvt.JsonEventRestaurantEvent;
import com.entreprise.efood.utils.AppConstant;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping(path = AppConstant.EVENT_REST_PATH_API)
public class EventController {
   
    private JsonEventRestaurantEvent eventService;

    public EventController(JsonEventRestaurantEvent eventService){
        this.eventService = eventService;
    }

    @PostMapping(value="/")
    public EventDTO createRestaurantEvents(@RequestBody EventDTO event) {
        
        eventService.createEvent(event);
        
        return event;
    }

    @GetMapping(value="/{restaurant_id}")
    public List<EventDTO> getMethodName(@PathVariable("restaurant_id") String restaurant_id) {
        return eventService.getEventsByRestaurant(restaurant_id);
    }
    
   
    
}
