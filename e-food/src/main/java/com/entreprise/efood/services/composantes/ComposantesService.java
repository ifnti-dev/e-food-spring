package com.entreprise.efood.services.composantes;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.entreprise.efood.dtos.ComposantDTO;

// signature des différentes méthodes du controlleur des composantes
public interface ComposantesService {
    // cette methode retourne la liste des composantes sous la forme d'un tableau de
    // clé valeur (clée: liste des composantes)
    public ResponseEntity<Map<String, List<ComposantDTO>>> getAllComposants();

    public ResponseEntity<Map<String, String>> addComponsant(ComposantDTO composantDTO);

    public ResponseEntity<Map<String, String>> updateComposant(ComposantDTO composantDTO, String id);

    public ResponseEntity<Map<String, String>> deleteComposant(String id);

}
