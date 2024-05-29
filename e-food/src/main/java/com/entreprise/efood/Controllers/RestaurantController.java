package com.entreprise.efood.Controllers;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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



    @PutMapping("/updateRestaurant/{code}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable Long code, @RequestBody RestaurantDTO restaurantDTO) {
        try {
            RestaurantDTO updatedRestaurant = restaurantService.updateRestaurant(code, restaurantDTO);
            return ResponseEntity.ok(updatedRestaurant);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    
    @DeleteMapping(value = "/deleteRestaurant/{code}")
    public ResponseEntity<String> deleteRestaurant(@RequestBody Map<String, Long> requestBody) {
        Long code = requestBody.get("code");
        restaurantService.deleteRestaurant(code);
        return ResponseEntity.ok("Restaurant supprimé avec succès");
    }



    @GetMapping("/getRestaurantById/{code}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable("code") Long code) {
        try {
            return restaurantService.getRestaurantById(code);
        } 
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourne 404 si le restaurant n'est pas trouvé
        }
    }

}
