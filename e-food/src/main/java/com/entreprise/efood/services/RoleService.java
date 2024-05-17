package com.entreprise.efood.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Role;
import com.entreprise.efood.dtos.RoleDTO;
import com.entreprise.efood.mapper.RoleMapper;
import com.entreprise.efood.repository.PermissionRepository;
import com.entreprise.efood.repository.RoleRepository;
import com.entreprise.efood.repository.UserRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRepository userRepository;


    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;

    }

    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setLibelle(roleDTO.getLibelle());
        role.setUsers(userRepository.findAllById(roleDTO.getUsers()));
        role.setPermissions(permissionRepository.findAllById(roleDTO.getPermissions()));
        Role savedRole = roleRepository.save(role);
        return RoleMapper.maptoRoleDto(savedRole);
    }


    public RoleDTO getRoleById(Long roleId){
        
        Role role= roleRepository.findById(roleId).orElseThrow();
        return RoleMapper.maptoRoleDto(role);

    }

    public List<RoleDTO> getAllRoles() {
        // TODO Auto-generated method stub

        List<Role> roles=roleRepository.findAll();
        return roles.stream().map((role) -> RoleMapper.maptoRoleDto(role)).collect(Collectors.toList());
    }

    public RoleDTO updateRole(Long roleId, RoleDTO updatedRole) {
        // TODO Auto-generated method stub
        Role role = roleRepository.findById(roleId).orElseThrow();

        role.setLibelle(updatedRole.getLibelle());
        role.setUsers(userRepository.findAllById(updatedRole.getUsers()));
        role.setPermissions(permissionRepository.findAllById(updatedRole.getPermissions()));
        Role updateRole = roleRepository.save(role);

        return RoleMapper.maptoRoleDto(updateRole);
    }

    public RoleDTO removeRole(Long roleId) {
        // TODO Auto-generated method stub

        Role role = roleRepository.findById(roleId).orElseThrow();
        roleRepository.delete(role);

        return RoleMapper.maptoRoleDto(role);
    }

}
