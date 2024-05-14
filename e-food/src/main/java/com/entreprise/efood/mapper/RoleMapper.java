package com.entreprise.efood.mapper;

import com.entreprise.efood.Models.Role;
import com.entreprise.efood.Models.User;
import com.entreprise.efood.dtos.RoleDTO;

public class RoleMapper {

    public static RoleDTO maptoRoleDto(Role role){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setLibelle(role.getLibelle());
        roleDTO.setPermissions(role.getPermissions());
        return roleDTO;
    }

    public static Role maptoRole(RoleDTO roleDTO){
        Role role=new Role();
            role.setId(roleDTO.getId());
            role.setLibelle(roleDTO.getLibelle());
            role.setPermissions(roleDTO.getPermissions());
            
        return role;
    }
    

}
