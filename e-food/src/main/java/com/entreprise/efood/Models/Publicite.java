package com.entreprise.efood.Models;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "publicites")

public class Publicite {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
  
    @Basic
    @Column(name = "titre",length = 30, nullable = false)
    private String titre;

    @Basic
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "publicite")
    private List<Image> images;

    public Publicite(String id, String titre, String description, Restaurant restaurant, List<Image> images) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.restaurant = restaurant;
        this.images = images;
    }

    public Publicite(String id, String titre, String description, Restaurant restaurant) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.restaurant = restaurant;
    }

    public Publicite() {
    }
    

    public void setId(String id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Image> getImages() {
        return images;
    }

    



    

}
