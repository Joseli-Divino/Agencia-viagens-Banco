package com.api.travelagency.controller;

import com.api.travelagency.dto.UserRegistrationDTO;
import com.api.travelagency.model.User;
import com.api.travelagency.service.CustomUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;

    public AuthController(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User userRequest) {
        try {
            userDetailsService.registerNewUser(userRequest.getUsername(), userRequest.getPassword());
            return ResponseEntity.ok(userRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
