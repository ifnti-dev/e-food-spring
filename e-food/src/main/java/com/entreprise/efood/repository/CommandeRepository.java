package com.entreprise.efood.repository;

import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Commande;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long>{

}
