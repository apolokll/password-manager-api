package com.apolokll.passwordmanager.service;

import com.apolokll.passwordmanager.entity.User;
import com.apolokll.passwordmanager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User registerUser(String email, String username, String password){
        if (userRepository.findByEmail(email).isPresent()){
            throw new RuntimeException("Email already registered.");
        }

        String encodePassword = passwordEncoder.encode(password); //criptografa a senha e guarda em encodePassword

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encodePassword);

        return userRepository.save(user);
    }
}
