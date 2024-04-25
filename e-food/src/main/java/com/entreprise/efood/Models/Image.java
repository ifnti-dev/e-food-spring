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
import jakarta.persistence.Table;

@Entity
@Table(name = "images",schema = AppConstant.SCHEMA_MENU)
public class Image {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name ="url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "publicite_id")
    private Publicite publicite;
    
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setPublicite(Publicite publicite) {
        this.publicite = publicite;
    }

    public String getUrl() {
        return url;
    }

    public Menu getMenu() {
        return menu;
    }

    public Publicite getPublicite() {
        return publicite;
    }

   

}
