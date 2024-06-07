package com.entreprise.efood.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
    private String username;
    
    private String password;
    
    private String nom;

    private String prenom;

    private String adresse;

    private String telephone;

    private String ville;

    private String email;
    
    // getters and setters here...
}