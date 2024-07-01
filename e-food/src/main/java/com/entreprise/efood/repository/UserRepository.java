package com.entreprise.efood.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.User;
import com.entreprise.efood.dtos.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    
    @Query("SELECT new com.entreprise.efood.dtos.UserDTO(r.id, r.username, r.password, r.nom, r.prenom, r.adresse, r.telephone, r.ville , r.email,r.role.id) FROM User r ")
    public List<UserDTO> getAllUsers();

    @Query("SELECT new com.entreprise.efood.dtos.UserDTO(u.id, u.username, u.password, u.nom, u.prenom, u.adresse, u.telephone, u.ville, u.email, u.role.libelle) FROM User u")
    List<UserDTO> findAllUsersWithRole();

}
