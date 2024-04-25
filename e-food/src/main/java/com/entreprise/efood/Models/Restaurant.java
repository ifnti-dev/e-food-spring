package com.entreprise.efood.Models;


import jakarta.persistence.Table;


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

@Entity
@Table(name = "restaurants",schema = AppConstant.SCHEMA_RESTAURANT)
public class Restaurant {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_id_seq")
    @SequenceGenerator(name = "restaurant_id_seq", sequenceName = "restaurant_id_seq",allocationSize = 100)
    private String id;
    
    @Basic
    @Column(name = "nom", length = 30, nullable = false)
    private String nom;

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
    @Column(name = "jour_ouverture", nullable = false)
    private ArrayList<String> jour_ouverture;

    @Basic
    @Column(name = "coordonnee_gps_x",length = 50)
    private String coordonnee_gps_x;

    @Basic
    @Column(name = "coordonnee_gps_y",length = 50)
    private String coordonnee_gps_y;

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

    public Restaurant(List<Employee> employees) {
        this.employees = employees;
    }

    public Restaurant(String id, String nom, String adresse, String telephone, String heure_ouverture,
            String heure_fermeture, ArrayList<String> jour_ouverture, String coordonnee_gps_x, String coordonnee_gps_y,
            String etat, List<Evenement> evenements, List<Adhesion> adhesions, List<Publicite> publicites,
            List<Menu> menus, List<Employee> employees) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.jour_ouverture = jour_ouverture;
        this.coordonnee_gps_x = coordonnee_gps_x;
        this.coordonnee_gps_y = coordonnee_gps_y;
        this.etat = etat;
        this.evenements = evenements;
        this.adhesions = adhesions;
        this.publicites = publicites;
        this.menus = menus;
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHeure_ouverture() {
        return heure_ouverture;
    }

    public void setHeure_ouverture(String heure_ouverture) {
        this.heure_ouverture = heure_ouverture;
    }

    public String getHeure_fermeture() {
        return heure_fermeture;
    }

    public void setHeure_fermeture(String heure_fermeture) {
        this.heure_fermeture = heure_fermeture;
    }

    public ArrayList<String> getJour_ouverture() {
        return jour_ouverture;
    }

    public void setJour_ouverture(ArrayList<String> jour_ouverture) {
        this.jour_ouverture = jour_ouverture;
    }

    public String getCoordonnee_gps_x() {
        return coordonnee_gps_x;
    }

    public void setCoordonnee_gps_x(String coordonnee_gps_x) {
        this.coordonnee_gps_x = coordonnee_gps_x;
    }

    public String getCoordonnee_gps_y() {
        return coordonnee_gps_y;
    }

    public void setCoordonnee_gps_y(String coordonnee_gps_y) {
        this.coordonnee_gps_y = coordonnee_gps_y;

    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    public List<Adhesion> getAdhesions() {
        return adhesions;
    }

    public void setAdhesions(List<Adhesion> adhesions) {
        this.adhesions = adhesions;
    }

    public List<Publicite> getPublicites() {
        return publicites;
    }

    public void setPublicites(List<Publicite> publicites) {
        this.publicites = publicites;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    

}
