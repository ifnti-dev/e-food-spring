package com.entreprise.efood.Models;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "adhesions" ,schema = AppConstant.SCHEMA_RESTAURANT)

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Adhesion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY  ,generator = "adhesion_id_seq")
    @SequenceGenerator(name = "adhesion_id_seq", sequenceName = "adhesion_id_seq",allocationSize = 10)
    private Long id;

    @Basic
    @Column(name = "avis", nullable = false)
    private String avis;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    

}
