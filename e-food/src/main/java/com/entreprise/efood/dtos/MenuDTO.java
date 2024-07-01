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

    public MenuDTO(Long id, String nom, double prix, String temps_preparation, String statut) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.temps_preparation = temps_preparation;
        this.statut = statut;

    }

    @Override
    public String toString() {
        return "MenuDTO [id=" + id + ", nom=" + nom + ", prix=" + prix + ", temps_preparation=" + temps_preparation
                + ", statut=" + statut + ", images=" + images + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", restaurant=" + restaurant + ", composants=" + composants + "]";
    }

}
