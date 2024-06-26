package com.entreprise.efood.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
        
    private Long id ;

    private String username;
    
    private String password;
    
    private String nom;

    private String prenom;

    private String adresse;

    private String telephone;

    private String ville;

    private String email;
    
    private Long role_id;
    }