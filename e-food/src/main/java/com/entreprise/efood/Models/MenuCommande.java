package com.entreprise.efood.Models;

import java.util.ArrayList;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_commandes",schema = AppConstant.SCHEMA_MENU)
public class MenuCommande {

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt=Instant.now();

   
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt=Instant.now();

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "commandes_id")
    private Commande commande;


    @ManyToOne
    @JoinColumn(name = "menus_id")
    private Menu menu;

      

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "preference")
    private ArrayList<String> preference;
    
    public MenuCommande() {
    }

    public MenuCommande(Long id, Commande commande, Menu menu, int quantite, ArrayList<String> preference) {
        this.id = id;
        this.commande = commande;
        this.menu = menu;
        this.quantite = quantite;
        this.preference = preference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public ArrayList<String> getPreference() {
        return preference;
    }

    public void setPreference(ArrayList<String> preference) {
        this.preference = preference;
    }




}
