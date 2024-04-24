package com.entreprise.efood.Models;

import java.sql.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "evenements")
public class Evenement {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq",allocationSize = 10)
    private Long id;
  
    

    @Basic
    @Column(name = "titre",length=30, nullable = false)
    private String titre;

    @Basic
    @Column(name = "description",length = 30, nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_debut")
    private Date date_debut;

    public Evenement() {
    }

    public Evenement(Long id, String titre, String description, Date date_debut, Date date_fin) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Evenement(Long id, String titre, String description, Date date_debut, Date date_fin,
            Restaurant restaurant) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.restaurant = restaurant;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_fin")
    private Date date_fin;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }


    public String getTitre() {
        return titre;
    }


    public String getDescription() {
        return description;
    }


    public Date getDate_debut() {
        return date_debut;
    }


    public Date getDate_fin() {
        return date_fin;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    
}
