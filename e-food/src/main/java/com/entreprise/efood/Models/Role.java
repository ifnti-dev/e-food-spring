package com.entreprise.efood.Models;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles",schema = AppConstant.SCHEMA_STAFF)
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Basic
    @Column(name = "libelle", nullable = false)
    private String libelle;
    


    @OneToMany(mappedBy = "role")
    private List<Employee> employees;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "role_permissions",
    joinColumns = @JoinColumn(name= "permission_id",referencedColumnName = "id"),
    inverseJoinColumns=@JoinColumn( name ="role_id",referencedColumnName = "id"),
    schema = AppConstant.SCHEMA_STAFF)

    private List<Permission> permissions;

    public Role(Long id, String libelle, List<Employee> employees, List<Permission> permissions) {
        this.id = id;
        this.libelle = libelle;
        this.employees = employees;
        this.permissions = permissions;
    }

    public Role() {
    }

    public Role(Long id, String libelle, List<Employee> employees) {
        this.id = id;
        this.libelle = libelle;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
