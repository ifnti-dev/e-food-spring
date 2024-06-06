package com.entreprise.efood.services.composantes;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.entreprise.efood.dtos.ComposantDTO;

// signature des différentes méthodes du controlleur des composantes
public interface ComposantesService {
    // cette methode retourne la liste des composantes sous la forme d'un tableau de
    // clé valeur (clée: liste des composantes)
    public ResponseEntity getAllComposants(Long restaurant_id);

    public ResponseEntity addComponsant(ComposantDTO composantDTO);

    public ResponseEntity updateComposant(ComposantDTO composantDTO, String id);

    public ResponseEntity deleteComposant(String id);

}
