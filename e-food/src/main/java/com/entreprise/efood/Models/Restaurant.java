package com.entreprise.efood.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_id_seq")
    @SequenceGenerator(name = "restaurant_id_seq", sequenceName = "restaurant_id_seq",  allocationSize=50)
    private String id_restaurant;

    @Column(name = "nom",length = 50)
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone",unique = true)
    private String telephone;

    @Column(name = "ville",length = 100)
    private String ville;

    @Column(name = "heure_ouverture")
    private String heure_ouverture;

    @Column(name = "heure_fermeture")
    private String heure_fermeture;

    @Basic
    @Column(name = "jours_ouverture", columnDefinition = "text[]")
    private ArrayList<String> jours_ouverture;

    @Basic
    @Column(name = "coordonnee_latitude", unique=true)
    private double coordonnee_latitude;
    
    @Basic
    @Column(name = "coordonnee_longitude",unique = true)
    private double coordonnee_longitude;

    @Column(name = "etat")
    private String etat;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Evenement> evenements;


    @OneToMany
    private List<Adhesion> adhesions;


    @OneToMany
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Adhesion> getAdhesions() {
        return adhesions;
    }

    public void setAdhesions(List<Adhesion> adhesions) {
        this.adhesions = adhesions;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    public String getId_restaurant() {
        return id_restaurant;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getHeure_ouverture() {
        return heure_ouverture;
    }

    public void setHeure_ouverture(String heure_ouverture) {
        this.heure_ouverture = heure_ouverture;
    }

    public String getHeure_fermeture() {
        return heure_fermeture;
    }

    public void setHeure_fermeture(String heure_fermeture) {
        this.heure_fermeture = heure_fermeture;
    }

    public ArrayList<String> getJours_ouverture() {
        return jours_ouverture;
    }

    public void setJours_ouverture(ArrayList<String> jours_ouverture) {
        this.jours_ouverture = jours_ouverture;
    }

    public double getCoordonnee_latitude() {
        return coordonnee_latitude;
    }

    public void setCoordonnee_latitude(double coordonnee_latitude) {
        this.coordonnee_latitude = coordonnee_latitude;
    }

    public double getCoordonnee_longitude() {
        return coordonnee_longitude;
    }

    public void setCoordonnee_longitude(double coordonnee_longitude) {
        this.coordonnee_longitude = coordonnee_longitude;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    // Getters and setters
    
}
