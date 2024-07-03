package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.dtos.commandeDTO.RetrieveCmdDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;






@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long>{


    @Query("SELECT new com.entreprise.efood.dtos.RetrieveCmdDTO(cmd.id,cmd.montant) FROM Commande cmd Where cmd.etat=:etat")
     Page<RetrieveCmdDTO> findCommandsByEtat(@Param("etat") String etat,Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Commande cmd SET cmd.etat=:statut WHERE cmd.id=:id")
    public void updateCommandStatus(@Param("statut") String statut,@Param("id") Long id);
}
