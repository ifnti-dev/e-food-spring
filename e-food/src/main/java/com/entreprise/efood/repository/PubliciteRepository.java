package com.entreprise.efood.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.entreprise.efood.Models.Image;
import com.entreprise.efood.Models.Publicite;
import com.entreprise.efood.dtos.PubliciteDTO;
import org.springframework.data.repository.query.Param;

public interface PubliciteRepository extends JpaRepository<Publicite, Long> {
     @Query("SELECT new com.entreprise.efood.Models.Image(i) FROM Image i "
            + " WHERE i.publicite.id=:pubID")
    public List<Image> getEventImages(@Param("pubID") String pubID);


    @Query("select new com.entreprise.efood.dtos.PubliciteDTO(p) from Publicite p")
    public List<PubliciteDTO> findAllPub() ;

    @Query("select new com.entreprise.efood.dtos.PubliciteDTO(p.id, p.titre, p.description) from Publicite p "+
    "WHERE p.restaurant.id=:restaurant_id"
    )
    public List<PubliciteDTO> findAllPubByresto(@Param("restaurant_id") Long restaurant_id) ;





   
}


