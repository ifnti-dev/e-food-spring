package com.entreprise.efood.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Adhesion;
import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.Models.exeptionHandle.InterneExpection;
import com.entreprise.efood.dtos.AdhesionDTO;
import com.entreprise.efood.dtos.RestaurantDTO;
import com.entreprise.efood.repository.AdhesionRepository;
import com.entreprise.efood.repository.RestaurantRepository;

@Service
public class AdhesionService implements AdhesionInterface {

    @Autowired
    private AdhesionRepository adhesionRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;



    public AdhesionDTO mappedAdhesionDTO(Adhesion ad) {
        AdhesionDTO AdhesionDTO = new AdhesionDTO();
        AdhesionDTO.setId(ad.getId());
        AdhesionDTO.setAvis(ad.getAvis());
        AdhesionDTO.setRestaurant(ad.getRestaurant());

        return AdhesionDTO;
    }



    @Override
    public ResponseEntity<List<AdhesionDTO>> getAllAdhesion() {
        try {
            List<AdhesionDTO> adhesions = adhesionRepository.getAllAdhesion();
            return new ResponseEntity<>(adhesions, HttpStatus.OK);
        } 
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Map<String , String> createAdhesion(Map<String , String> adhesionDTO) {
        try {
            Adhesion adhesion = new Adhesion();
            adhesion.setAvis(adhesionDTO.get("avis"));
            adhesion.setRestaurant(restaurantRepository.getById(Long.parseLong((adhesionDTO.get("restaurant")))));
            
            // Si l'ID est null, laissez Hibernate générer automatiquement l'ID
            if ((adhesionDTO.get("restaurant"))!= null) {
                adhesion.setId(Long.parseLong((adhesionDTO.get("restaurant"))));
            }

           adhesionRepository.save(adhesion);
            return adhesionDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    @Override
    public void deleteAdhésions(Long id) {
       
         // Récupérerons le restaurant par son code, ou lancer une exception si non trouvé
        Adhesion adhesion =  adhesionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("adhesion non trouvé avec l'id': " + id));

        // Suppresion du restaurant
        adhesionRepository.deleteById(id);
        
    }

    @Override
    public AdhesionDTO updateAdhesion(Map<String, String> adhesionDTO) {
        try {
            Long adhesionId = Long.parseLong(adhesionDTO.get("id"));
            Adhesion adhesion = adhesionRepository.findById(adhesionId)
                                .orElseThrow(() -> new RuntimeException("Adhesion not found"));
    
            // Vérifier si "avis" est présent dans la map et n'est pas null
            if (adhesionDTO.containsKey("avis") && adhesionDTO.get("avis") != null) {
                adhesion.setAvis(adhesionDTO.get("avis"));
            }
            
            // Set other fields accordingly
    
            Adhesion updatedAdhesion = adhesionRepository.save(adhesion);
            return mappedAdhesionDTO(updatedAdhesion);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid adhesion id format");
        }
    }


    @Override
    public ResponseEntity<AdhesionDTO> getAdhesionById(Long id) {
        try {
            // Récupérons le restaurant par son ID
            Adhesion adhesion = adhesionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("adhésion non trouvé avec le code: " + id));
            
            // Mappage de l'objet Restaurant en RestaurantDTO
            AdhesionDTO adhesionDTO = mappedAdhesionDTO(adhesion);

            return ResponseEntity.ok(adhesionDTO);
        } 
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourne 404 si le restaurant n'est pas trouvé
        }
    }

    
}
