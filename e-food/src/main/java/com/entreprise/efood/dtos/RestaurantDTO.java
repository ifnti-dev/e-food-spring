package com.entreprise.efood.dtos;

import org.springframework.web.multipart.MultipartFile;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    
    private Long code;

    @NotNull
    private String nom;

    @NotNull
    private String ville;

    @NotNull
    private String adresse;

    @NotNull
    private String telephone;

    @NotNull
    private String heure_ouverture;

    @NotNull
    private String heure_fermeture;

    @NotNull
    private String jour_ouverture;

    @NotNull
    private String etat;

    @NotNull
    private double coordonnee_gps_x;

    @NotNull
    private double coordonnee_gps_y;

    @NotNull
    private MultipartFile photoFile; 

    private String photoProfil;
}
