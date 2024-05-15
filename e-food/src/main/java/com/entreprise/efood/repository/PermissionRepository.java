package com.entreprise.efood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entreprise.efood.Models.Permission;

public interface PermissionRepository extends JpaRepository<Permission,Long> {

}
