package com.entreprise.efood.Models;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "paiements",schema = AppConstant.SCHEMA_COMMAND)
public class Paiement {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paiement_id_sep")
    @SequenceGenerator(name = "paiement_id_sep", sequenceName = "paiement_id_sep",allocationSize = 10)
    private Long id;

    
    @Column(name = "montant", nullable = false)
    private double montant;

    @Column(name = "prix_livraison", nullable = false)
    private double prix_livraison;

    @Column(name = "type_paiement", nullable = false)
    private String type_paiement;

    @Column(name = "numero_paiement")
    private String numero_paiement;

    @Column(name = "statut")
    private String statut;

    public Paiement(Long id, double montant, double prix_livraison, String type_paiement, String numero_paiement,
            String statut) {
        this.id = id;
        this.montant = montant;
        this.prix_livraison = prix_livraison;
        this.type_paiement = type_paiement;
        this.numero_paiement = numero_paiement;
        this.statut = statut;
    }

    public Paiement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getPrix_livraison() {
        return prix_livraison;
    }

    public void setPrix_livraison(double prix_livraison) {
        this.prix_livraison = prix_livraison;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    public String getNumero_paiement() {
        return numero_paiement;
    }

    public void setNumero_paiement(String numero_paiement) {
        this.numero_paiement = numero_paiement;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }






    

}
