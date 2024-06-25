package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.dtos.RetrieveCmdDTO;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long>{


    @Query("SELECT new com.entreprise.efood.dtos.RetrieveCmdDTO(cmd.id,cmd.montant) FROM Commande cmd Where cmd.etat=:etat")
     Page<RetrieveCmdDTO> findCommandsByEtat(@Param("etat") String etat,Pageable pageable);

}
