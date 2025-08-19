import org.springframework.security.crypto.password.PasswordEncoder;
    @Autowired
    private PasswordEncoder passwordEncoder;
package com.loginpage.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginpage.demo.UserDetails.UserEntity;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserEntity user) {
        PasswordEncoder passwordEncoder;
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
