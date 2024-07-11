package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.dtos.commandeDTO.DetailsClientCommandeDTO;
import com.entreprise.efood.dtos.commandeDTO.RetrieveCmdDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;






@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long>{


    @Query("SELECT new com.entreprise.efood.dtos.commandeDTO.RetrieveCmdDTO(cmd.montant,cmd.id,cmd.date_commande,cmd.client.user.nom,cmd.client.user.prenom,cmd.etat) FROM Commande cmd WHERE cmd.etat=:etat AND FUNCTION('DATE',cmd.date_commande) = CURRENT_DATE  ORDER BY cmd.date_commande ASC")
     Page<RetrieveCmdDTO> findCommandsByEtat(@Param("etat") String etat,Pageable pageable);

     @Query("SELECT new com.entreprise.efood.dtos.commandeDTO.RetrieveCmdDTO(cmd.montant,cmd.id,cmd.date_commande,cmd.client.user.nom,cmd.client.user.prenom,cmd.etat) FROM Commande cmd"
     + " JOIN cmd.menuCommandes mc "+
     " JOIN mc.menu m "
     + " WHERE m.restaurant = :restaurant"+" ORDER BY cmd.date_commande DESC")
     Page<RetrieveCmdDTO> findAllCommands(Pageable pageable,@Param("restaurant") Restaurant restaurant);

    @Transactional
    @Modifying
    @Query("UPDATE Commande cmd SET cmd.etat=:statut WHERE cmd.id=:id")
    void updateCommandStatus(@Param("statut") String statut,@Param("id") Long id);

    @Query("SELECT new com.entreprise.efood.dtos.commandeDTO.DetailsClientCommandeDTO(cmd.id,cmd.date_commande,cmd.montant) FROM Commande cmd WHERE cmd.client.id=:id")
    Page<DetailsClientCommandeDTO> retrieveClientCommands(@Param("id") Long idClient, Pageable pageable);
   
}

// "SELECT c FROM Commande c WHERE c.client IN "
//            + "(SELECT DISTINCT cmd.client FROM MenuCommande mc "
//            + "JOIN mc.menu m JOIN m.restaurant r JOIN mc.commande cmd "
//            + "WHERE r = :restaurant)";