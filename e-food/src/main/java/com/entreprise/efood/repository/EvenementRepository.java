package com.entreprise.efood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entreprise.efood.Models.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long>{

    

}
