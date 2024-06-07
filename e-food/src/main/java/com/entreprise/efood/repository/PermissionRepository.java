package com.entreprise.efood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entreprise.efood.Models.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {


}
