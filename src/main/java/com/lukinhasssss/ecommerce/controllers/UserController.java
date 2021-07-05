package com.lukinhasssss.ecommerce.controllers;

import com.lukinhasssss.ecommerce.dto.request.UserRequest;
import com.lukinhasssss.ecommerce.entities.User;
import com.lukinhasssss.ecommerce.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid UserRequest userRequest) {
        User user = userRequest.convertToEntity(passwordEncoder);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

}
