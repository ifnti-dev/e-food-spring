package com.entreprise.efood.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entreprise.efood.Models.Publicite;
import com.entreprise.efood.dtos.PubliciteDTO;
import org.springframework.data.repository.query.Param;

public interface PubliciteRepository extends JpaRepository<Publicite, Long> {

    @Query("select new com.entreprise.efood.dtos.PubliciteDTO(p) from Publicite p")
    public List<PubliciteDTO> findAllPub() ;

    @Query("select new com.entreprise.efood.dtos.PubliciteDTO(p) from Publicite p "+
    "WHERE p.restaurant.id=:restaurant_id"
    )
    public List<PubliciteDTO> findAllPubByresto(@Param("restaurant_id") Long restaurant_id) ;





   
}


