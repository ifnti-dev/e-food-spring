package com.entreprise.efood.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.dtos.RoleDTO;
import com.entreprise.efood.services.RoleService;
@CrossOrigin("*")
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createrole")
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO){
        RoleDTO saveRole = roleService.createRole(roleDTO);
        return new ResponseEntity<>(saveRole,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Long roleId){
        RoleDTO roleDTO = roleService.getRoleById(roleId);
        return ResponseEntity.ok(roleDTO);
    }

    @GetMapping()
    public ResponseEntity<List<RoleDTO>> getAllRoles(){
        List<RoleDTO> roleDTOs = roleService.getAllRoles();
        return ResponseEntity.ok(roleDTOs);
    }

    @PutMapping("{id}")
    public ResponseEntity<RoleDTO> updateRole( @PathVariable("id") Long roleId, @RequestBody RoleDTO updatedRole){
        RoleDTO roleDTO= roleService.updateRole(roleId, updatedRole);
        return ResponseEntity.ok(roleDTO);
    }

    @PostMapping("{id}")
    public ResponseEntity<RoleDTO> removeRole(@PathVariable("id") Long roleId){
        RoleDTO roleDTO = roleService.removeRole(roleId);
        return ResponseEntity.ok(roleDTO);
    }



}
