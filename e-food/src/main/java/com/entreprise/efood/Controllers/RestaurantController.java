package com.entreprise.efood.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.entreprise.efood.constants.RestaurantConstant;
import com.entreprise.efood.dtos.RestaurantDTO;
import com.entreprise.efood.services.RestaurantService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = RestaurantConstant.RESTAURANT_REQUEST_MAPPING)
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/ListeRestaurant")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurant() {
        try {
            return restaurantService.getAllRestaurants();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/SaveRestaurant")
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestPart("restaurant") RestaurantDTO restaurantDTO,
                                                          @RequestPart("photoFile") MultipartFile photoFile) {
        try {
            RestaurantDTO createdRestaurant = restaurantService.createRestaurant(restaurantDTO, photoFile);
            return ResponseEntity.ok(createdRestaurant);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/updateRestaurant/{code}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable Long code,
                                                   @RequestPart("restaurant") RestaurantDTO restaurantDTO,
                                                   @RequestPart(value = "photoFile", required = false) MultipartFile photoFile) {
        try {
            RestaurantDTO updatedRestaurant = restaurantService.updateRestaurant(code, restaurantDTO, photoFile);
            return ResponseEntity.ok(updatedRestaurant);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deleteRestaurant/{code}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("code") Long code) {
        try {
            restaurantService.deleteRestaurant(code);
            return ResponseEntity.ok("Restaurant supprimé avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getRestaurantById/{code}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable("code") Long code) {
        try {
            return restaurantService.getRestaurantById(code);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
