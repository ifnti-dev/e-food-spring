package com.entreprise.efood.Models;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.entreprise.efood.utils.AppConstant;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "livraisons",schema = AppConstant.SCHEMA_COMMAND)
public class Livraison {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liv_id_seq")
    @SequenceGenerator(name = "liv_id_seq", sequenceName = "liv_id_seq",allocationSize = 10)
    private Long id;
      
    @Column( nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 100, nullable = false)
    private Timestamp date;

    
    @Column(length = 30, nullable = false)
    private String statut;

    
    @Column(length = 30, nullable = false)
    private double coordonnee_x;

    
    @Column(length = 30, nullable = false)
    private double coordonnee_y;

    // @ManyToOne
    // @JoinColumn(name = "employee_id")
    // private Employee employee;

    @OneToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;


}
