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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "publicites",schema = AppConstant.SCHEMA_RESTAURANT)

public class Publicite {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Basic
    @Column(name = "titre",length = 30, nullable = false)
    private String titre;

    @Basic
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "publicite")
    private List<Image> images;

}
