package com.entreprise.efood.Models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commande_id_seq")
    @SequenceGenerator(name = "commande_id_seq", sequenceName = "commande_id_seq",allocationSize = 10)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_commande")
    private String date_commande;

    @Column(name = "etat",columnDefinition = "l'etat de la commande: traité/encours/en attente")
    private String etat;

    @Column(name = "montant")
    private double montant;


    public Commande(Long id, String date_commande, String etat, double montant, Client client) {
        this.id = id;
        this.date_commande = date_commande;
        this.etat = etat;
        this.montant = montant;
        this.client = client;
    }

    public Commande() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public Paiement getLivraison() {
        return Livraison;
    }

    public void setLivraison(Paiement livraison) {
        Livraison = livraison;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    

    


    @OneToOne
    @JoinColumn(name = "paiement_id")
    private Paiement paiement;

    @OneToOne
    @JoinColumn(name = "livraison_id")
    private Paiement Livraison;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<MenuCommande> menuCommandes;

    public List<MenuCommande> getMenuCommandes() {
        return menuCommandes;
    }

    public void setMenuCommandes(List<MenuCommande> menuCommandes) {
        this.menuCommandes = menuCommandes;
    }

}