package com.rent.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rent.read.contants.Role;
import com.rent.read.entity.Users;
import com.rent.read.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class UserController {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
   // @Autowired
    private Role role;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole(role.USER);
        }
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
    
    @GetMapping("/getUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
    	return ResponseEntity.ok(userRepository.findAll());
    }
}
