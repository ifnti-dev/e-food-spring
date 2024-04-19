package com.entreprise.efood.Models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "adhesions")
public class Adhesion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "avis", nullable = false)
    private String avis;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    

    public Adhesion() {
    }

    public Adhesion(Long id, String avis, Restaurant restaurant) {
        this.id = id;
        this.avis = avis;
        this.restaurant = restaurant;
    }

    public Adhesion(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public Long getId() {
        return id;
    }

    public String getAvis() {
        return avis;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    



    

}
