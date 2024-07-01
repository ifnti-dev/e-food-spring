package com.entreprise.efood.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.User;
import com.entreprise.efood.dtos.UserDTO;
import com.entreprise.efood.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> allUsers() {
        List<UserDTO> users = new ArrayList<>();

        userRepository.getAllUsers().forEach(users::add);

        return users;
    }
}
