package com.entreprise.efood.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDto {
    private String username;
    
    private String password;
    
    // getters and setters here...
}