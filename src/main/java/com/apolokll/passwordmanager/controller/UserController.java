package com.apolokll.passwordmanager.controller;

import com.apolokll.passwordmanager.dto.RegisterUserRequest;
import com.apolokll.passwordmanager.entity.User;
import com.apolokll.passwordmanager.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public User userRegister(@RequestBody RegisterUserRequest request){
        return userService.registerUser(
                request.getEmail(),
                request.getUsername(),
                request.getPassword()
        );
    }
}
