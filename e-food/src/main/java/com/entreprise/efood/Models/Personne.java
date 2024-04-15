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
import jakarta.persistence.Table;

/**
 *
 * @author david
 */
@Entity 
@Table(name = "personne")
public class Personne {
  
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pers_id;
  
    @Basic
    @Column(length = 30, nullable = false)
    private String nom;
    
    @Basic
    @Column(length = 30, nullable = false)
    private String prenom;
    
    @Basic
    @Column(length = 15, nullable = false)
    private String telephone;
    
    @Basic
    @Column(length = 50, nullable = false, unique=true)
    private String email;
    
    @Basic
    @Column(length = 30, nullable = false) 
    private String ville;
    
    @Basic
    @Column(length = 30, nullable = false)
    private String addresse;
    
    //private String profile;
     
    
    

    public Personne() {
        
    }
    
    
    public Personne(String nom, String prenom, String telephone, String email, String ville, String addresse) {
       this.nom = nom;
       this.prenom = prenom;
       this.telephone = telephone;
       this.email = email;
       this.ville = ville;
       this.addresse = addresse;
      

   }
     public Long getPersone_id() {
        return pers_id;
    }

    public void setPersone_id(Long pers_id) {
        this.pers_id = pers_id;
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
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

   /* public String getProfile() {
        return profile;
    }*/

    @Override
    public String toString() {
        return super.toString(); 
    }

    
    
}
