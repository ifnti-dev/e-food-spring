package com.entreprise.efood.dtos.commandeDTO;

import java.sql.Timestamp;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.Models.Livraison;

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
  
    private Long code;
    private Timestamp dateCmde;
    // private Timestamp dateLivraison;
    private double montant;
    // private String nomResto;
    // private  Livraison liraison;
    // private Commande cmd;


}