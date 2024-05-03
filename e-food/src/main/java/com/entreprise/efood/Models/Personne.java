/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entreprise.efood.Models;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author roland
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@MappedSuperclass()
// @Table(name = "personnes",schema = AppConstant.SCHEMA_STAFF)
public abstract class Personne {
  
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Basic
    @Column(name = "nom",length = 30, nullable = false)
    private String nom;
    
    @Basic
    @Column(name = "prenom",length = 30, nullable = false)
    private String prenom;
    
    @Basic
    @Column(name = "telephone", nullable = false,unique = true)
    private String telephone;
    
    @Basic
    @Column(name = "email", unique=true)
    private String email;
    
    @Basic
    @Column(name = "ville") 
    private String ville;
    
    @Basic
    @Column( name = "adresse")
    private String adresse;

    @Override
    public String toString() {
        return super.toString(); 
    }
}
