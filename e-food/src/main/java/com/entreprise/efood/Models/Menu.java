package com.entreprise.efood.Models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class Menu {
    @Id
    @Column(name = "code" ,nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_id_seq")
    @SequenceGenerator(name = "menu_id_seq", sequenceName = "menu_id_seq",  allocationSize=50)
    private String code;

    @Basic
    @Column(name = "nom" ,nullable = false)
    private String nom;

    @Column(name = "prix" ,nullable = false)
    private double prix;

    @Column(name = "description" ,nullable = true,columnDefinition = "Un text qui decrit le menu")
    private String description;

    @Column(name = "temps_preparation",columnDefinition = "le temps de cuisson")
    private int tempsPreparation;

    @Column(name = "statut" ,nullable = false,columnDefinition = "")
    private String statut;

    @ManyToOne
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }



}
