package com.entreprise.efood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.Models.exeptionHandle.InterneExpection;
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
            System.out.println(resto);
            return new ResponseEntity<>(restaurantRepository.getAllRestaurants(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {

        // ArrayList<String> jours=new ArrayList<>();
        // jours.add(restaurantDTO.getJour_ouverture());
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
            System.out.println(restaurant);
            restaurantRepository.save(restaurant);
            return restaurantDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // cette méthode mette à jour un restaurant en fonction des données fournies
    // dans le corps de la requête, puis renvoie un objet
    // contenant des informations sur la mise à jour effectuée, y compris l'ID du
    // restaurant et l'objet RestaurantDTO mis à jour.

    // public RestaurantDTO mappedRestaurantDTO(Restaurant r) {
    // RestaurantDTO restaurantDTO = new RestaurantDTO();
    // restaurantDTO.setCode(r.getCode());
    // restaurantDTO.setNom(r.getNom());
    // restaurantDTO.setVille(r.getVille());
    // restaurantDTO.setAdresse(r.getAdresse());
    // restaurantDTO.setTelephone(r.getTelephone());
    // restaurantDTO.setHeure_ouverture(r.getHeure_ouverture());
    // restaurantDTO.setHeure_fermeture(r.getHeure_fermeture());
    // restaurantDTO.setJour_ouverture(r.getJour_ouverture());
    // restaurantDTO.setEtat(r.getEtat());
    // restaurantDTO.setCoordonnee_gps_x(r.getCoordonnee_gps_x());
    // restaurantDTO.setCoordonnee_gps_y(r.getCoordonnee_gps_y());
    // return restaurantDTO;
    // }

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
                entity.getCoordonnee_gps_y());
    }

    @Override
    public RestaurantDTO updateRestaurant(Long code, RestaurantDTO restaurantDTO) {
        if (code == null) {
            throw new IllegalArgumentException("Restaurant code is required");
        }

        // Trouver le restaurant par ID
        Restaurant resto = restaurantRepository.findById(code)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found with code: " + code));

        // Mettre à jour les champs du restaurant avec les valeurs du DTO
        mapDtoToEntity(restaurantDTO, resto);

        // Enregistrer les modifications
        Restaurant updatedRestaurant = restaurantRepository.save(resto);

        // Retourner le DTO mis à jour
        return mapEntityToDto(updatedRestaurant);
    }

    // public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
    // Restaurant resto = new Restaurant();
    // if (restaurantDTO.getCode() != null) {
    // resto = this.restaurantRepository.getById(restaurantDTO.getCode());
    // resto.setCode(restaurantDTO.getCode());
    // resto.setNom(restaurantDTO.getNom());
    // resto.setVille(restaurantDTO.getVille());
    // resto.setAdresse(restaurantDTO.getAdresse());
    // resto.setTelephone(restaurantDTO.getTelephone());
    // resto.setHeure_ouverture(restaurantDTO.getHeure_ouverture());
    // resto.setHeure_fermeture(restaurantDTO.getHeure_fermeture());
    // resto.setJour_ouverture(restaurantDTO.getJour_ouverture());
    // resto.setEtat(restaurantDTO.getEtat());
    // resto.setCoordonnee_gps_x(restaurantDTO.getCoordonnee_gps_x());
    // resto.setCoordonnee_gps_y(restaurantDTO.getCoordonnee_gps_y());
    // } else {
    // throw new InterneExpection("Restaurant uuid is requiered", null);
    // }
    // //cette ligne de code enregistre un objet Restaurant dans la base de données,
    // puis le convertit en un objet RestaurantDTO
    // //à l'aide de la méthode mappedRestaurantDTO() avant de le renvoyer.
    // return this.mappedRestaurantDTO(this.restaurantRepository.save(resto));
    // }

    @Override
    public void deleteRestaurant(Long code) {

        // Récupérerons le restaurant par son code, ou lancer une exception si non
        // trouvé
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
