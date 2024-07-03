package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.Models.Livraison;
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


    @Query("SELECT new com.entreprise.efood.dtos.commandeDTO.RetrieveCmdDTO(cmd.id,cmd.montant) FROM Commande cmd WHERE cmd.etat=:etat ORDER BY cmd.date_commande ASC")
     Page<RetrieveCmdDTO> findCommandsByEtat(@Param("etat") String etat,Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Commande cmd SET cmd.etat=:statut WHERE cmd.id=:id")
    void updateCommandStatus(@Param("statut") String statut,@Param("id") Long id);

    @Query("SELECT new com.entreprise.efood.dtos.commandeDTO.DetailsClientCommandeDTO(cmd.id,cmd.date_commande,cmd.montant) FROM Commande cmd WHERE cmd.client.id=:id")
    Page<DetailsClientCommandeDTO> retrieveClientCommands(@Param("id") Long idClient, Pageable pageable);
   
}
