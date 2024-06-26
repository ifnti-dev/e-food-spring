package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Menu;
import com.entreprise.efood.dtos.MenuDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT new com.entreprise.efood.dtos.MenuDTO(m.id, m.nom, m.prix, m.temps_preparation, m.statut, m.restaurant.id) FROM Menu m WHERE m.restaurant.id=:restaurant_id ")
    public List<MenuDTO> getMenus(@Param("restaurant_id") Long restaurant_id);

    @Query("SELECT new com.entreprise.efood.dtos.MenuDTO(m.id, m.nom, m.prix, m.temps_preparation, m.statut, m.restaurant.id) FROM Menu m WHERE m.id=:menu_id")
    public MenuDTO getMenuById(@Param("menu_id") Long menu_id);
}
