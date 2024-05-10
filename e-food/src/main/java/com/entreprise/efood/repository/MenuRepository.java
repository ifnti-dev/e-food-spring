package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Menu;
import com.entreprise.efood.dtos.MenuDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT new com.entreprise.efood.dtos.MenuDTO(m.id, m.nom, m.prix, m.temps_preparation, m.statut, m.restaurant) FROM Menu m")
    public List<MenuDTO> getMenus();
}
