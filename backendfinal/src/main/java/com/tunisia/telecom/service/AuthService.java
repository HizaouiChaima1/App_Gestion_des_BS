package com.tunisia.telecom.service;

import com.tunisia.telecom.entity.Employe;
import com.tunisia.telecom.repository.EmployeRepository;
import com.tunisia.telecom.dto.*;
import com.tunisia.telecom.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private EmployeRepository employeRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtils jwtUtils;
    
    public JwtResponse login(LoginRequest loginRequest) {
        Employe employe = employeRepository.findByMatricule(loginRequest.getMatricule())
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
        
        if (!passwordEncoder.matches(loginRequest.getMotDePasse(), employe.getMotDePasse())) {
            throw new RuntimeException("Mot de passe incorrect");
        }
        
        String jwt = jwtUtils.generateJwtToken(employe.getMatricule());
        
        return new JwtResponse(jwt, employe.getMatricule(), employe.getNom(), 
                              employe.getPrenom(), employe.getEmail());
    }
    
    public Employe register(RegisterRequest registerRequest) {
        if (employeRepository.existsByMatricule(registerRequest.getMatricule())) {
            throw new RuntimeException("Ce matricule existe déjà");
        }
        
        if (employeRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Cet email existe déjà");
        }
        
        Employe employe = new Employe();
        employe.setMatricule(registerRequest.getMatricule());
        employe.setNom(registerRequest.getNom());
        employe.setPrenom(registerRequest.getPrenom());
        employe.setEmail(registerRequest.getEmail());
        employe.setMotDePasse(passwordEncoder.encode(registerRequest.getMotDePasse()));
        
        return employeRepository.save(employe);
    }
}