package com.entreprise.efood.Models;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "commandes",schema = AppConstant.SCHEMA_COMMAND)
public class Commande {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commande_id_seq")
    @SequenceGenerator(name = "commande_id_seq", sequenceName = "commande_id_seq",allocationSize = 10)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_commande")
    private Timestamp date_commande;

    @Column(name = "etat")
    private String etat;
    

    @Column(name = "montant")
    private double montant;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<MenuCommande> menuCommandes;

}
