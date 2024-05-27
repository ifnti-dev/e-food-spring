package com.entreprise.efood.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.entreprise.efood.dtos.AdhesionDTO;
import com.entreprise.efood.Models.Adhesion;

@Repository
public interface AdhesionRepository extends JpaRepository<Adhesion, Long> {

    @Query("SELECT new com.entreprise.efood.dtos.AdhesionDTO(ad.id, ad.avis, ad.restaurant) FROM Adhesion ad")
    public List<AdhesionDTO> getAllAdhesion();
}




