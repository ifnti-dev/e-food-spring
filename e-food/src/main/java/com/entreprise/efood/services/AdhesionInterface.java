package com.entreprise.efood.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.entreprise.efood.dtos.AdhesionDTO;

public interface AdhesionInterface {
    ResponseEntity<List<AdhesionDTO>> getAllAdhesion();

    Map<String , String> createAdhesion(Map<String , String>adhesionDTO);
    AdhesionDTO updateAdhesion(Map<String , String> adhesionDTO);
    ResponseEntity<AdhesionDTO> getAdhesionById(Long id);
    void deleteAdhésions(Long id);
}


