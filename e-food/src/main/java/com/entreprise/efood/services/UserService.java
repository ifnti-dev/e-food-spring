package com.entreprise.efood.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.entreprise.efood.dtos.RegisterUserDto;
import com.entreprise.efood.dtos.UserDTO;
import com.entreprise.efood.Models.Role;
import com.entreprise.efood.Models.User;
import com.entreprise.efood.repository.RoleRepository;
import com.entreprise.efood.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
        this.roleRepository=roleRepository;
    }

    // Récupérer tous les utilisateurs
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    // Récupérer un utilisateur par ID
    public UserDTO getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(this::convertToDTO).orElse(null);
    }

        public User addUser( UserDTO input) {
            
        Role roleUser = roleRepository.findById(input.getRole_id()).orElseThrow();
        
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

    // Ajouter un nouvel utilisateur
    

    // Mettre à jour un utilisateur existant
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setNom(userDTO.getNom());
            userToUpdate.setPrenom(userDTO.getPrenom());
            userToUpdate.setEmail(userDTO.getEmail());
            userToUpdate.setTelephone(userDTO.getTelephone());
            userToUpdate.setAdresse(userDTO.getAdresse());
            userToUpdate.setVille(userDTO.getVille());
            userToUpdate.setUsername(userDTO.getUsername());
            userToUpdate.setPassword(userDTO.getPassword());
            
            // Mettre à jour d'autres champs selon les besoins

            User updatedUser = userRepository.save(userToUpdate);
            return convertToDTO(updatedUser);
        }
        return null; // Retourner null si l'utilisateur n'est pas trouvé
    }

    // Supprimer un utilisateur
    public boolean deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return true;
        }
        return false; // Retourner false si l'utilisateur n'est pas trouvé
    }

    // Méthode utilitaire pour convertir User en UserDTO
    private UserDTO convertToDTO(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setNom(user.getNom());
        userDto.setPrenom(user.getPrenom());
        userDto.setEmail(user.getEmail());
        userDto.setTelephone(user.getTelephone());
        userDto.setAdresse(user.getAdresse());
        userDto.setVille(user.getVille());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRole_id(user.getRole().getId());
        // Ajoutez d'autres champs si nécessaire
        return userDto;
    }

    // Méthode utilitaire pour convertir UserDTO en User
    private User convertToEntity(UserDTO userDTO) {
        Role role = new Role();
        role.setId(userDTO.getId());
        User user = new User();
        user.setId(userDTO.getId());
        user.setNom(userDTO.getNom());
        user.setPrenom(userDTO.getPrenom());
        user.setEmail(userDTO.getEmail());
        user.setTelephone(userDTO.getTelephone());
        user.setAdresse(userDTO.getAdresse());
        user.setVille(userDTO.getVille());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(role);
        
        // Ajoutez d'autres champs si nécessaire
        return user;
    }
}
