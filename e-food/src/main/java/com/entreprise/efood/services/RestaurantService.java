package com.entreprise.efood.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.dtos.RestaurantDTO;
import com.entreprise.efood.repository.RestaurantRepository;

@Service
public class RestaurantService implements RestaurantInterface {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private final String uploadDir = "uploads/";

    @Override
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        try {
            List<Restaurant> restaurants = restaurantRepository.findAll();
            List<RestaurantDTO> restaurantDTOs = new ArrayList<>();
            for (Restaurant restaurant : restaurants) {
                restaurantDTOs.add(mapEntityToDto(restaurant));
            }
            return new ResponseEntity<>(restaurantDTOs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO, MultipartFile photoFile) {
        try {
            Restaurant restaurant = new Restaurant();
            mapDtoToEntity(restaurantDTO, restaurant);

            if (photoFile != null && !photoFile.isEmpty()) {
                String fileName = savePhotoFile(photoFile);
                restaurant.setPhotoProfil(fileName);
                restaurantDTO.setPhotoProfil(fileName);
            }

            restaurantRepository.save(restaurant);
            return restaurantDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String savePhotoFile(MultipartFile photoFile) throws IOException {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + photoFile.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, photoFile.getBytes());
        return fileName;
    }

    private void mapDtoToEntity(RestaurantDTO dto, Restaurant entity) {
        entity.setNom(dto.getNom());
        entity.setVille(dto.getVille());
        entity.setAdresse(dto.getAdresse());
        entity.setTelephone(dto.getTelephone());
        entity.setHeure_ouverture(dto.getHeure_ouverture());
        entity.setHeure_fermeture(dto.getHeure_fermeture());
        entity.setJour_ouverture(dto.getJour_ouverture());
        entity.setEtat(dto.getEtat());
        entity.setCoordonnee_gps_x(dto.getCoordonnee_gps_x());
        entity.setCoordonnee_gps_y(dto.getCoordonnee_gps_y());
        entity.setPhotoProfil(dto.getPhotoProfil());
    }

    private RestaurantDTO mapEntityToDto(Restaurant entity) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setCode(entity.getCode());
        dto.setNom(entity.getNom());
        dto.setVille(entity.getVille());
        dto.setAdresse(entity.getAdresse());
        dto.setTelephone(entity.getTelephone());
        dto.setHeure_ouverture(entity.getHeure_ouverture());
        dto.setHeure_fermeture(entity.getHeure_fermeture());
        dto.setJour_ouverture(entity.getJour_ouverture());
        dto.setEtat(entity.getEtat());
        dto.setCoordonnee_gps_x(entity.getCoordonnee_gps_x());
        dto.setCoordonnee_gps_y(entity.getCoordonnee_gps_y());
        dto.setPhotoProfil(entity.getPhotoProfil());
        return dto;
    }

    @Override
    public RestaurantDTO updateRestaurant(Long code, RestaurantDTO restaurantDTO, MultipartFile photoFile) {
        if (code == null) {
            throw new IllegalArgumentException("Restaurant code is required");
        }

        Restaurant restaurant = restaurantRepository.findById(code)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found with code: " + code));

        mapDtoToEntity(restaurantDTO, restaurant);

        if (photoFile != null && !photoFile.isEmpty()) {
            try {
                String fileName = savePhotoFile(photoFile);
                restaurant.setPhotoProfil(fileName);
                restaurantDTO.setPhotoProfil(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return mapEntityToDto(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long code) {
        Restaurant restaurant = restaurantRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Restaurant non trouvé avec le code: " + code));

        restaurantRepository.deleteById(code);
    }

    @Override
    public ResponseEntity<RestaurantDTO> getRestaurantById(Long code) {
        try {
            Restaurant restaurant = restaurantRepository.findById(code)
                    .orElseThrow(() -> new RuntimeException("Restaurant non trouvé avec le code: " + code));

            RestaurantDTO restaurantDTO = mapEntityToDto(restaurant);
            return ResponseEntity.ok(restaurantDTO);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
