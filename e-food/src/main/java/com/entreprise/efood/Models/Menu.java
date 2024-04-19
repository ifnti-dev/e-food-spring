package com.entreprise.efood.Models;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_id_seq")
    @SequenceGenerator(name = "menu_id_seq", sequenceName = "menu_id_seq",allocationSize = 50)
    private Long id;

    @Basic
    @Column(name = "nom",length = 30, nullable = false)
    private String nom;

    
    @Column(name = "prix", nullable = false)
    private double prix;

    @Basic
    @Column(name = "temps_preparation", nullable = false)
    private int temps_preparation;

    @Basic
    @Column(name = "statut", nullable = false)
    private String statut;

    @OneToMany(mappedBy = "menu")
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Menu() {
    }

    public Menu(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Menu(Long id, String nom, double prix, int temps_preparation, String statut) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.temps_preparation = temps_preparation;
        this.statut = statut;
    }

    public Menu(Long id, String nom, double prix, int temps_preparation, String statut, List<Image> images,
            Restaurant restaurant) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.temps_preparation = temps_preparation;
        this.statut = statut;
        this.images = images;
        this.restaurant = restaurant;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setTemps_preparation(int temps_preparation) {
        this.temps_preparation = temps_preparation;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getTemps_preparation() {
        return temps_preparation;
    }

    public String getStatut() {
        return statut;
    }

    public List<Image> getImages() {
        return images;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
    
    @OneToMany(mappedBy = "menu")
    private List<MenuCommande> menuCommandes;

    @ManyToMany
    @JoinTable( name = "menu_composant",
    joinColumns = @JoinColumn(name= "menu_id",referencedColumnName = "code"),
    inverseJoinColumns=@JoinColumn( name ="composant_id",referencedColumnName = "code"))
    private List<Composant> composants;
    
}


