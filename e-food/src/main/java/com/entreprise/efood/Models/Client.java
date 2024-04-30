package com.entreprise.efood.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Client extends Personne {
    
    @Basic
    @Column(name = "favoris")
    private ArrayList<Restaurant> favoris;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    
}
