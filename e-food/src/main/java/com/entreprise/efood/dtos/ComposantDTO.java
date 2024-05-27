package com.entreprise.efood.dtos;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

import com.entreprise.efood.Models.Menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ComposantDTO {

    private Long id;

    private String nom;

    private double prix;

    private ArrayList<String> composition;

    private List<Menu> menus;

    private Instant createdAt = Instant.now();

    private Instant updatedAt = Instant.now();

    // constructeur permettant de récuperer les ou un composant(s) sans ses menus
    public ComposantDTO(Long id, String nom, double prix, ArrayList<String> composition, Instant createdAt,
            Instant updatedAt) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.composition = composition;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ComposantDTO [id=" + id + ", nom=" + nom + ", prix=" + prix + ", composition=" + composition
                + ", menus=" + menus + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
