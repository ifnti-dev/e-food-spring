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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "menu_commandes",schema = AppConstant.SCHEMA_MENU)
public class MenuCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt=Instant.now();
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt=Instant.now();

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
    
}
