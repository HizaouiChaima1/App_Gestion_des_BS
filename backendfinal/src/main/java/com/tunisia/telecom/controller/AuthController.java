package com.tunisia.telecom.controller;

import com.tunisia.telecom.dto.*;
import com.tunisia.telecom.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            JwtResponse response = authService.login(loginRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Erreur: " + e.getMessage()));
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {
        try {
            authService.register(registerRequest);
            return ResponseEntity.ok(new MessageResponse("Employé enregistré avec succès!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Erreur: " + e.getMessage()));
        }
    }
}

// MessageResponse.java
class MessageResponse {
    private String message;
    
    public MessageResponse(String message) {
        this.message = message;
    }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}