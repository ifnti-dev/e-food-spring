package com.entreprise.efood.mapper;

import com.entreprise.efood.Models.Role;
import com.entreprise.efood.Models.User;
import com.entreprise.efood.dtos.RoleDTO;

public class RoleMapper {

    public static RoleDTO maptoRoleDto(Role role){
        return new RoleDTO(role.getLibelle());
    }

    public static Role maptoRole(RoleDTO roleDTO){
        Role role=new Role();
            role.setLibelle(roleDTO.getLibelle());
        return role;
    }
    

}
