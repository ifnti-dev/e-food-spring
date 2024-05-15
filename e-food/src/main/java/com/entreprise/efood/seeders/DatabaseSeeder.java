package com.entreprise.efood.seeders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.entreprise.efood.Models.Permission;
import com.entreprise.efood.Models.Role;
import com.entreprise.efood.Models.User;
import com.entreprise.efood.repository.PermissionRepository;
import com.entreprise.efood.repository.RoleRepository;
import com.entreprise.efood.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository=permissionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //
        Permission create_restaurant = new Permission();
        create_restaurant.setLibelle("create_restaurant");
        permissionRepository.save(create_restaurant);

        Permission edit_restaurant = new Permission();
        edit_restaurant.setLibelle("edit_restaurant");
        permissionRepository.save(edit_restaurant);

        Permission delete_restaurant = new Permission();
        delete_restaurant.setLibelle("delete_restaurant");
        permissionRepository.save(delete_restaurant);

        Permission list_restaurant = new Permission();
        list_restaurant.setLibelle("list_restaurant");
        permissionRepository.save(list_restaurant);

        List<Permission> admin_permission = new ArrayList<>();
        admin_permission.add(list_restaurant);
        admin_permission.add(delete_restaurant);
        admin_permission.add(edit_restaurant);
        admin_permission.add(create_restaurant);

        List<Permission> client_permission = new ArrayList<>();
        client_permission.add(list_restaurant);
     



        


        // Créer des rôles
        Role roleAdmin = new Role();
        roleAdmin.setLibelle("ADMIN");
        roleAdmin.setPermissions(admin_permission);
        roleRepository.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setLibelle("ROLE_USER");
        roleUser.setPermissions(client_permission);
        roleRepository.save(roleUser);

        // Créer des utilisateurs
        User user1 = new User();
        user1.setNom("Nom1");
        user1.setPrenom("Prenom1");
        user1.setUsername("user1");
        user1.setPassword("password1");
        user1.setTelephone("0123456789");
        user1.setEmail("user1@example.com");
        user1.setVille("Ville1");
        user1.setAdresse("Adresse1");
        user1.setCreatedAt(new Date());
        user1.setUpdatedAt(new Date());
        user1.setRole(roleAdmin);
        userRepository.save(user1);

        User user2 = new User();
        user2.setNom("Nom2");
        user2.setPrenom("Prenom2");
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setTelephone("9876543210");
        user2.setEmail("user2@example.com");
        user2.setVille("Ville2");
        user2.setAdresse("Adresse2");
        user2.setCreatedAt(new Date());
        user2.setUpdatedAt(new Date());
        user2.setRole(roleUser);
        userRepository.save(user2);

    }


}
