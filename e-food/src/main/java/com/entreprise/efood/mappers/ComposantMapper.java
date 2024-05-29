package com.entreprise.efood.mappers;

import com.entreprise.efood.Models.Composant;
import com.entreprise.efood.dtos.ComposantDTO;

public class ComposantMapper {

    public static Composant maptoComposant(ComposantDTO composantDTO, Composant composant) {
        if (composantDTO.getId() != null) {
            composant.setId(composantDTO.getId());
        }
        composant.setNom(composantDTO.getNom());
        composant.setPrix(composantDTO.getPrix());
        composant.setComposition(composantDTO.getComposition());
        return composant;
    }

    public static ComposantDTO mapToComposantDTO(Composant composant) {
        ComposantDTO composantDTO = new ComposantDTO();
        composantDTO.setId(composant.getId());
        composantDTO.setNom(composant.getNom());
        composantDTO.setPrix(composant.getPrix());
        composantDTO.setComposition(composant.getComposition());
        return composantDTO;
    }
}