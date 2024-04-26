/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entreprise.efood.Models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

/**
 *
 * @author david
 */

@MappedSuperclass
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

    @Column(name = "profile")
    private String profile;
     
    
    

    public Personne() {
        
    }
    
    
    
    public Personne(Long id, String nom, String prenom, String telephone, String email, String ville, String adresse,
            String profile) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.ville = ville;
        this.adresse = adresse;
        this.profile = profile;
    }



    public Personne(String nom, String prenom, String telephone, String email, String ville, String addresse) {
       this.nom = nom;
       this.prenom = prenom;
       this.telephone = telephone;
       this.email = email;
       this.ville = ville;
       this.adresse = addresse;
      

   }

   
     public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getAdresse() {
        return adresse;
    }



    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public String getProfile() {
        return profile;
    }



    public void setProfile(String profile) {
        this.profile = profile;
    }



    public Long getPersone_id() {
        return id;
    }

    public void setPersone_id(Long pers_id) {
        this.id = pers_id;
    }
     
   public String getNom(){
       return this.nom;
   }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAddresse() {
        return adresse;
    }

    public void setAddresse(String addresse) {
        this.adresse = addresse;
    }

   /* public String getProfile() {
        return profile;
    }*/

    @Override
    public String toString() {
        return super.toString(); 
    }

    
    
}
