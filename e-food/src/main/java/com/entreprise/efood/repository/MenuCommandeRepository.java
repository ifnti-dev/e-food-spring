package com.entreprise.efood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.Models.MenuCommande;
import com.entreprise.efood.dtos.MenuCommandeClientDTO;

import java.util.List;


@Repository
public interface MenuCommandeRepository extends JpaRepository<MenuCommande,Long> {

    @Query("SELECT new com.entreprise.efood.dtos.MenuCommandeClientDTO(mcmd.preference,mcmd.quantite,mcmd.menu.temps_preparation,mcmd.menu.prix,mcmd.menu.id) from MenuCommande mcmd where mcmd.commande.id=:id")
    List<MenuCommandeClientDTO> findByCommande(@Param("id") Long id);

}
