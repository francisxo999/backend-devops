package com.spotify.ms_users.controller;

import com.spotify.ms_users.model.User;
import com.spotify.ms_users.service.UserService;
import com.spotify.ms_users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return service.listarTodos();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.guardar(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}