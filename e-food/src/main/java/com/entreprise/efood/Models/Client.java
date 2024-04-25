package com.entreprise.efood.Models;

import java.util.ArrayList;
import java.util.List;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients",schema = AppConstant.SCHEMA_STAFF)
public class Client extends Personne {
    
    @Basic
    @Column(name = "favoris")
    private ArrayList<Restaurant> favoris;

    public Client(ArrayList<Restaurant> favoris, List<Commande> commandes) {
        this.favoris = favoris;
        this.commandes = commandes;
    }

    public Client(String nom, String prenom, String telephone, String email, String ville, String addresse,
            ArrayList<Restaurant> favoris, List<Commande> commandes) {
        super(nom, prenom, telephone, email, ville, addresse);
        this.favoris = favoris;
        this.commandes = commandes;
    }

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    public ArrayList<Restaurant> getFavoris() {
        return favoris;
    }

    public void setFavoris(ArrayList<Restaurant> favoris) {
        this.favoris = favoris;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
