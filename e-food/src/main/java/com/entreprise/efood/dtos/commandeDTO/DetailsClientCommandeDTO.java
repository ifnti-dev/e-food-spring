package com.entreprise.efood.dtos.commandeDTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DetailsClientCommandeDTO
 */
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class DetailsClientCommandeDTO {
  
    private Long id;
    private Timestamp dateCmde;
    private Timestamp dateLivraison;
    private double montant;
    private String nomResto;


}