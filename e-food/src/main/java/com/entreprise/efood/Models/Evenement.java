package com.entreprise.efood.Models;

import java.io.Serializable;
import java.sql.Date;



import com.entreprise.efood.utils.AppConstant;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "evenements",schema = AppConstant.SCHEMA_RESTAURANT)
public class Evenement implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq",allocationSize = 10)
    private Long id;
  
    

    @Basic
    @Column(name = "titre",length=30, nullable = false)
    private String titre;

    @Basic
    @Column(name = "description",nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut")
    private Date date_debut;

    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin")
    private Date date_fin;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    
}
