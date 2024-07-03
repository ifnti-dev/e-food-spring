package com.entreprise.efood.dtos.commandeDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCommandeDTO {
    private String preference;
    private int quantite; 
}
