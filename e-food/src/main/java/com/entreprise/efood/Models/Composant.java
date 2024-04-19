package com.entreprise.efood.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "composants")
public class Composant {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Basic
    @Column(name ="nom", nullable = false)
    private String nom;

    @Column(name ="prix", nullable = false)
    private double prix;

    @Column(name ="composition")
    private ArrayList<String> composition;

    @ManyToMany(mappedBy = "composants")
    private List<Menu> menus;

    

    public Composant(Long id, String nom, double prix, ArrayList<String> composition, List<Menu> menus) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.composition = composition;
        this.menus = menus;
    }

    public Composant(List<Menu> menus) {
        this.menus = menus;
    }

    public Composant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ArrayList<String> getComposition() {
        return composition;
    }

    public void setComposition(ArrayList<String> composition) {
        this.composition = composition;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    

    

}
