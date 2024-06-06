package com.entreprise.efood.dtos;

import java.time.Instant;

import java.util.List;

import com.entreprise.efood.Models.Composant;
import com.entreprise.efood.Models.Image;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class MenuDTO {

    private Long id;

    private String nom;

    private double prix;

    private String temps_preparation;

    private String statut;

    private List<Image> images;

    private Long restaurant_id;

    private List<Long> composants_ids;

    private List<Composant> composantes;

    private Instant createdAt = Instant.now();

    private Instant updatedAt = Instant.now();

    public MenuDTO(Long id, String nom, double prix, String temps_preparation, String statut, List<Image> images,
            Long restaurant_id,
            List<Long> composants_ids) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.temps_preparation = temps_preparation;
        this.statut = statut;
        this.images = images;
        this.restaurant_id = restaurant_id;
        this.composants_ids = composants_ids;
    }

    public MenuDTO(Long id, String nom, double prix, String temps_preparation, String statut, Long restaurant_id) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.temps_preparation = temps_preparation;
        this.statut = statut;
        this.restaurant_id = restaurant_id;
    }

    @Override
    public String toString() {
        return "MenuDTO [id=" + id + ", nom=" + nom + ", prix=" + prix + ", temps_preparation=" + temps_preparation
                + ", statut=" + statut + ", images=" + images + ", restaurant_id=" + restaurant_id + ", composants_ids="
                + composants_ids + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + "]";
    }

}
