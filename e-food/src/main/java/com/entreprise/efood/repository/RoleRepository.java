package com.entreprise.efood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    
} 