package com.entreprise.efood.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.entreprise.efood.dtos.RestaurantDTO;

public interface RestaurantInterface {
    ResponseEntity<List<RestaurantDTO>> getAllRestaurants();

    RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO);
}
