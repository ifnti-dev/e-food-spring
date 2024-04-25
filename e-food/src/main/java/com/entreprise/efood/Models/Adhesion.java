package com.entreprise.efood.Models;

import com.entreprise.efood.utils.AppConstant;

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
@Table(name = "adhesions",schema = AppConstant.SCHEMA_RESTAURANT)
public class Adhesion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Basic
    @Column(name = "avis", nullable = false)
    private String avis;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    

    public Adhesion() {
    }

    public Adhesion(String id, String avis, Restaurant restaurant) {
        this.id = id;
        this.avis = avis;
        this.restaurant = restaurant;
    }

    public Adhesion(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public String getId() {
        return id;
    }

    public String getAvis() {
        return avis;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    



    

}
