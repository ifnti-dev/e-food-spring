package com.entreprise.efood.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.entreprise.efood.Models.Publicite;

public interface PubliciteRepository extends JpaRepository<Publicite, Long> {
     @Query("SELECT new com.entreprise.efood.Models.Image(i) FROM Image i "
            + " WHERE i.publicite_id=:pubID")
    public List<Image> getEventImages(@Param("pubID") String pubID);


}

