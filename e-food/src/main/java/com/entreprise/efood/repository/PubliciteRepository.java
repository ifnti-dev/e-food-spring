package com.entreprise.efood.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entreprise.efood.Models.Publicite;
import com.entreprise.efood.dtos.PubliciteDTO;


public interface PubliciteRepository extends JpaRepository<Publicite, Long> {
    @Query("select new com.entreprise.efood.Models.Publicite(p.id, p.titre, p.description, p.restaurant, p.images) from Publicite p")
    public List<PubliciteDTO> findAllPub() ;

   
}


