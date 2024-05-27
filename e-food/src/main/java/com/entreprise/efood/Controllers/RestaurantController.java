package com.entreprise.efood.Controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.constants.RestaurantConstant;
import com.entreprise.efood.dtos.RestaurantDTO;
import com.entreprise.efood.services.RestaurantService;

@RestController
@RequestMapping(path = RestaurantConstant.RESTAURANT_REQUEST_MAPPING)
public class RestaurantController {

    @Autowired
    private  RestaurantService  restaurantService;

    @GetMapping("/ListeRestaurant")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurant() {
        try {
            return restaurantService.getAllRestaurants();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<RestaurantDTO>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/SaveRestaurant")
    public RestaurantDTO postMethodName(@RequestBody() RestaurantDTO restaurantDTO) {
        try {
            restaurantService.createRestaurant(restaurantDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    
}
