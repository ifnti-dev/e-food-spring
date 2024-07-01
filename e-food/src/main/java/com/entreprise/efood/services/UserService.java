package com.entreprise.efood.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.entreprise.efood.dtos.UserDTO;
import com.entreprise.efood.Models.User;

import com.entreprise.efood.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    // Ajouter un nouvel utilisateur
    public UserDTO addUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

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
        // Ajoutez d'autres champs si nécessaire
        return userDto;
    }

    // Méthode utilitaire pour convertir UserDTO en User
    private User convertToEntity(UserDTO userDTO) {
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
        // Ajoutez d'autres champs si nécessaire
        return user;
    }
}
