package com.entreprise.efood.dtos.commandeDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonDTO {
    private String description;
    private double coordonnee_x;
    private double coordonnee_y;
  
    //private int idLivreur;

}
