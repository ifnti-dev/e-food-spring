package com.entreprise.efood.Models;

import java.util.List;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Livraison",schema = AppConstant.SCHEMA_COMMAND)
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

    public Livraison(Long id, String code, String description, String date, String statut, Long coordonnee_x,
            Long coordonnee_y, Employee employee) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.date = date;
        this.statut = statut;
        this.coordonnee_x = coordonnee_x;
        this.coordonnee_y = coordonnee_y;
        this.employee = employee;
    }

    public Livraison(Long id, String code, String description, String date, String statut, Long coordonnee_x,
            Long coordonnee_y) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.date = date;
        this.statut = statut;
        this.coordonnee_x = coordonnee_x;
        this.coordonnee_y = coordonnee_y;
    }

    public Livraison() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Long getCoordonnee_x() {
        return coordonnee_x;
    }

    public void setCoordonnee_x(Long coordonnee_x) {
        this.coordonnee_x = coordonnee_x;
    }

    public Long getCoordonnee_y() {
        return coordonnee_y;
    }

    public void setCoordonnee_y(Long coordonnee_y) {
        this.coordonnee_y = coordonnee_y;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
