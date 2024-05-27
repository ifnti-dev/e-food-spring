package com.entreprise.efood.Models;


import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
import jakarta.persistence.SequenceGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "restaurants",schema = AppConstant.SCHEMA_RESTAURANT)
public class Restaurant {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_id_seq")
    @SequenceGenerator(name = "restaurant_id_seq", sequenceName = "restaurant_id_seq",allocationSize = 100)
    private Long code;
    
    @Basic
    @Column(name = "nom", length = 30, nullable = false)
    private String nom;

    @Basic
    @Column(name = "ville", length = 30, nullable = false)
    private String ville;

    @Basic
    @Column(name = "adresse")
    private String adresse;

    @Basic
    @Column(name = "telephone",length = 30, nullable = false, unique =true)
    private String telephone;

    @Basic
    @Column(name = "heure_ouverture", nullable = false)
    private String heure_ouverture;

    @Basic
    @Column(name = "heure_fermeture", nullable = false)
    private String heure_fermeture;

    @Basic
    @Column(name = "jour_ouverture", nullable = true)
    private ArrayList<String> jour_ouverture;

    @Basic
    @Column(name = "coordonnee_gps_x",length = 50)
    private double coordonnee_gps_x;

    @Basic
    @Column(name = "coordonnee_gps_y",length = 50)
    private double coordonnee_gps_y;

    @Basic
    @Column(length = 30, nullable = false)
    private String etat;

    @OneToMany(mappedBy = "restaurant")
    private List<Evenement> evenements;

    @OneToMany(mappedBy = "restaurant")
    private List<Adhesion> adhesions;


    @OneToMany(mappedBy = "restaurant")
    private List<Publicite> publicites;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

    @OneToMany(mappedBy = "restaurant")
    private List<Employee> employees;

    public Restaurant(Long id) {
        this.code = id;
    }



    

}
