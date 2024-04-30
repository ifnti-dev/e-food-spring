package com.entreprise.efood.Models;

import java.util.List;

import jakarta.persistence.Basic;
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
@Table(name = "Livraison")
public class Livraison {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Basic
    @Column(length = 30, nullable = false)
    private String code;

    @Basic
    @Column(length = 30, nullable = false)
    private String description;

    @Basic
    @Column(length = 30, nullable = false)
    private String date;

    @Basic
    @Column(length = 30, nullable = false)
    private String statut;

    @Basic
    @Column(length = 30, nullable = false)
    private Long coordonnee_x;

    @Basic
    @Column(length = 30, nullable = false)
    private Long coordonnee_y;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
