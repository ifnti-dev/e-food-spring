package com.entreprise.efood.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.entreprise.efood.dtos.RestaurantDTO;

public interface RestaurantInterface {

     ResponseEntity<List<RestaurantDTO>> getAllRestaurants();

     RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO,MultipartFile photoFile);

     ResponseEntity<RestaurantDTO> getRestaurantById(Long code);

     RestaurantDTO updateRestaurant(Long code, RestaurantDTO restaurantDTO,MultipartFile photoFile);
    

    void deleteRestaurant(Long code);

}
