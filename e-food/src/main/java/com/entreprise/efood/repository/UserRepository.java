package com.entreprise.efood.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entreprise.efood.Models.User;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
