package com.entreprise.efood.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "paiements")
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

    
}
