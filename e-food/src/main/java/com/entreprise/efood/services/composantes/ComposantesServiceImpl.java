package com.entreprise.efood.services.composantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Composant;
import com.entreprise.efood.dtos.ComposantDTO;
import com.entreprise.efood.repository.ComposantRepository;

@Service
public class ComposantesServiceImpl implements ComposantesService {

    @Autowired
    private ComposantRepository composantRepository;

    @Override
    /*
     * cette méthode permet de retourner la liste des composantes de menu
     * elle retourne une réponse Http contenant un message et un code HTTP
     */

    public ResponseEntity<Map<String, List<ComposantDTO>>> getAllComposants() {
        Map<String, List<ComposantDTO>> mappedComposants = new HashMap<>();
        try {
            List<ComposantDTO> composants = composantRepository.getComposants();
            mappedComposants.put("composantes", composants);
            return new ResponseEntity<Map<String, List<ComposantDTO>>>(mappedComposants, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mappedComposants.put("composantes", new ArrayList<>());
        return new ResponseEntity<Map<String, List<ComposantDTO>>>(mappedComposants, HttpStatus.OK);
    }

    @Override
    /*
     * cette méthode permet de créer une composante de menu
     * elle retourne une réponse Http contenant un message et un code HTTP
     */
    public ResponseEntity<String> addComponsant(ComposantDTO composantDTO) {
        try {
            Composant composant = new Composant();
            composant.setId(composantDTO.getId());
            composant.setNom(composantDTO.getNom());
            composant.setPrix(composantDTO.getPrix());
            composant.setComposition(composantDTO.getComposition());
            composantRepository.save(composant);
            return new ResponseEntity<String>("Composante de menu créée avec succès", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Erreur lors de la création de la composante de menu",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
