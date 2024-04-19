package com.entreprise.efood.Models;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends Personne{
    
    @Basic
    @Column(name = "statut", nullable = false)
    private String statut;

    @ManyToOne 
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    

    public Employee() {
    }

    public Employee(String nom, String prenom, String telephone, String email, String ville, String addresse) {
        super(nom, prenom, telephone, email, ville, addresse);
    }

    public Employee(String statut, Restaurant restaurant, Role role, List<Livraison> livraisons) {
        this.statut = statut;
        this.restaurant = restaurant;
        this.role = role;
        this.livraisons = livraisons;
    }

    public Employee(String nom, String prenom, String telephone, String email, String ville, String addresse,
            String statut, Restaurant restaurant, Role role, List<Livraison> livraisons) {
        super(nom, prenom, telephone, email, ville, addresse);
        this.statut = statut;
        this.restaurant = restaurant;
        this.role = role;
        this.livraisons = livraisons;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Livraison> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(List<Livraison> livraisons) {
        this.livraisons = livraisons;
    }

    @OneToMany(mappedBy = "employee")
    private List<Livraison> livraisons;
}
