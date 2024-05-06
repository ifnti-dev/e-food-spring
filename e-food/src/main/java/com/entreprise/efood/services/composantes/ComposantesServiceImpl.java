package com.entreprise.efood.services.composantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.dtos.ComposantDTO;
import com.entreprise.efood.repository.ComposantRepository;

@Service
public class ComposantesServiceImpl implements ComposantesService {

    @Autowired
    private ComposantRepository composantRepository;

    @Override
    // cette méthode retourne toutes les composantes
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

}
