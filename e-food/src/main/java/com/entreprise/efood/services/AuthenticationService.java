package com.entreprise.efood.services;

import com.entreprise.efood.Models.Role;
import com.entreprise.efood.Models.User;
import com.entreprise.efood.dtos.LoginUserDto;
import com.entreprise.efood.dtos.RegisterUserDto;
import com.entreprise.efood.repository.RoleRepository;
import com.entreprise.efood.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        Role roleUser = new Role();
        roleUser.setId((long) 2);
        roleUser.setLibelle("USER");

        User user = new User();
                user.setNom(input.getNom());
                user.setUsername(input.getUsername());
                user.setPassword(passwordEncoder.encode(input.getPassword()));
                user.setPrenom(input.getPrenom());
                user.setEmail(input.getEmail());
                user.setAdresse(input.getAdresse());
                user.setTelephone(input.getTelephone());
                user.setVille(input.getVille());
                user.setRole(roleUser);
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}