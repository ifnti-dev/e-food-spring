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
            List<RestaurantDTO> resto = restaurantRepository.getAllRestaurants();
            System.out.println(resto);
            return new ResponseEntity<>(restaurantRepository.getAllRestaurants(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO, MultipartFile photoFile) {
        try {
            Restaurant restaurant = new Restaurant();
            restaurant.setNom(restaurantDTO.getNom());
            restaurant.setVille(restaurantDTO.getVille());
            restaurant.setAdresse(restaurantDTO.getAdresse());
            restaurant.setTelephone(restaurantDTO.getTelephone());
            restaurant.setHeure_ouverture(restaurantDTO.getHeure_ouverture());
            restaurant.setHeure_fermeture(restaurantDTO.getHeure_fermeture());
            restaurant.setJour_ouverture(restaurantDTO.getJour_ouverture());
            restaurant.setEtat(restaurantDTO.getEtat());
            restaurant.setCoordonnee_gps_x(restaurantDTO.getCoordonnee_gps_x());
            restaurant.setCoordonnee_gps_y(restaurantDTO.getCoordonnee_gps_y());

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

        String fileName = photoFile.getOriginalFilename();
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
        entity.setPhotoProfil(dto.getPhotoProfil()); // Nouveau champ
    }

    private RestaurantDTO mapEntityToDto(Restaurant entity) {
        return new RestaurantDTO(
                entity.getCode(),
                entity.getNom(),
                entity.getVille(),
                entity.getAdresse(),
                entity.getTelephone(),
                entity.getHeure_ouverture(),
                entity.getHeure_fermeture(),
                entity.getJour_ouverture(),
                entity.getEtat(),
                entity.getCoordonnee_gps_x(),
                entity.getCoordonnee_gps_y(),
                entity.getPhotoProfil() // Nouveau champ
        );
    }

    @Override
    public RestaurantDTO updateRestaurant(Long code, RestaurantDTO restaurantDTO, MultipartFile photoFile) {
        if (code == null) {
            throw new IllegalArgumentException("Restaurant code is required");
        }

        // Trouver le restaurant par ID
        Restaurant resto = restaurantRepository.findById(code)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found with code: " + code));

        // Mettre à jour les champs du restaurant avec les valeurs du DTO
        mapDtoToEntity(restaurantDTO, resto);

        if (photoFile != null && !photoFile.isEmpty()) {
            try {
                String fileName = savePhotoFile(photoFile);
                resto.setPhotoProfil(fileName);
                restaurantDTO.setPhotoProfil(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Enregistrer les modifications
        Restaurant updatedRestaurant = restaurantRepository.save(resto);

        // Retourner le DTO mis à jour
        return mapEntityToDto(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long code) {
        // Récupérerons le restaurant par son code, ou lancer une exception si non trouvé
        Restaurant restaurant = restaurantRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Restaurant non trouvé avec le code: " + code));

        // Suppresion du restaurant
        restaurantRepository.deleteById(code);
    }

    @Override
    public ResponseEntity<RestaurantDTO> getRestaurantById(Long code) {
        try {
            // Récupérons le restaurant par son ID
            Restaurant restaurant = restaurantRepository.findById(code)
                    .orElseThrow(() -> new RuntimeException("Restaurant non trouvé avec le code: " + code));
            
            // Mappage de l'objet Restaurant en RestaurantDTO
            RestaurantDTO restaurantDTO = mapEntityToDto(restaurant);

            return ResponseEntity.ok(restaurantDTO);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourne 404 si le restaurant n'est pas trouvé
        }
    }
}
