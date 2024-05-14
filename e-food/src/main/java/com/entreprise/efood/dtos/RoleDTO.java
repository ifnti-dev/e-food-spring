package com.entreprise.efood.dtos;

import java.util.List;

import com.entreprise.efood.Models.Permission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    
    private Long id;
    private String libelle;
    private List<Permission> permissions;

}
