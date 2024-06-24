package com.entreprise.efood.dtos;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCommandeClientDTO {
    
    private String preference;
    private int quantite;
    private String temps_preparation;
    private double prix;

}
