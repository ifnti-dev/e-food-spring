package com.entreprise.efood.Models;

import java.util.List;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
// @Table(name = "menus", schema = AppConstant.SCHEMA_MENU)
@Table(name = "menus")
public class Menu {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_id_seq")
    @SequenceGenerator(name = "menu_id_seq", sequenceName = "menu_id_seq",allocationSize = 50)
    private Long id;

    @Basic
    @Column(name = "nom",length = 30, nullable = false)
    private String nom;

    @Column(name = "prix", nullable = false)
    private double prix;

    @Basic
    @Column(name = "temps_preparation", nullable = false)
    private String temps_preparation;

    @Basic
    @Column(name = "statut", nullable = false)
    private String statut;

    @OneToMany(mappedBy = "menu")
    private List<Image> images;

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt=Instant.now();

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt=Instant.now();

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToMany()
    @JoinTable( name = "menu_composant",
    joinColumns = @JoinColumn(name= "menu_id",referencedColumnName = "code"),
    inverseJoinColumns=@JoinColumn( name ="composant_id",referencedColumnName = "code")
    )
    private List<Composant> composants;

    
   
    
}



