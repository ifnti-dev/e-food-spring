package com.entreprise.efood.Models;

import java.io.Serializable;
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






@Setter
@Getter

@Entity
@Table(name = "publicites")

public class Publicite implements Serializable {
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

  // @JsonIgnore
    @OneToMany(mappedBy = "publicite")
   
    private List<Image> images;

    

  public Publicite() {
  }



  public Publicite(Long id, String titre, String description, Restaurant restaurant, List<Image> images) {
    this.id = id;
    this.titre = titre;
    this.description = description;
    this.restaurant = restaurant;
    this.images = images;
  }



    

}
