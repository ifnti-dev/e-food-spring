package com.entreprise.efood.Models;

import java.util.ArrayList;
import java.util.List;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients", schema = AppConstant.SCHEMA_STAFF)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Client {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic
    @Column(name = "favoris")
    private ArrayList<String> favoris;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    
}
