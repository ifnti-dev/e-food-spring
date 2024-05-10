package com.entreprise.efood.dtos;

import java.time.Instant;
import java.util.List;

import com.entreprise.efood.Models.Composant;
import com.entreprise.efood.Models.Image;
import com.entreprise.efood.Models.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class MenuDTO {

    private Long id;

    private String nom;

    private double prix;

    private String temps_preparation;

    private String statut;

    private List<Image> images;

    private Instant createdAt = Instant.now();

    private Instant updatedAt = Instant.now();

    private Restaurant restaurant;

    private List<Composant> composants;

}
