package com.entreprise.efood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.dtos.RestaurantDTO;
import com.entreprise.efood.repository.RestaurantRepository;
import java.util.ArrayList;
@Service
public class RestaurantService implements RestaurantInterface {

    @Autowired
    private RestaurantRepository restaurantRepository;

    

    @Override
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        try {
            List<RestaurantDTO> resto = restaurantRepository.getAllRestaurants();
            System.err.println(resto);
            return new ResponseEntity<>(restaurantRepository.getAllRestaurants(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {


        ArrayList<String> jours=new ArrayList<>();
        jours.add(restaurantDTO.getJour_ouverture());
        try {
            Restaurant restaurant = new Restaurant();
            restaurant.setNom(restaurantDTO.getNom());
            restaurant.setVille(restaurantDTO.getVille());
            restaurant.setAdresse(restaurantDTO.getAdresse());
            restaurant.setTelephone(restaurantDTO.getTelephone());
            restaurant.setHeure_ouverture(restaurantDTO.getHeure_ouverture());
            restaurant.setHeure_fermeture(restaurantDTO.getHeure_fermeture());
            restaurant.setJour_ouverture(jours);
            restaurant.setEtat(restaurantDTO.getEtat());
            restaurant.setCoordonnee_gps_x(restaurantDTO.getCoordonnee_gps_x());
            restaurant.setCoordonnee_gps_y(restaurantDTO.getCoordonnee_gps_x());
            System.out.println(restaurant);
            restaurantRepository.save(restaurant);
            return restaurantDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

    

