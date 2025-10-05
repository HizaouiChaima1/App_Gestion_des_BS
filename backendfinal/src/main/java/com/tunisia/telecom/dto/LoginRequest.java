package com.tunisia.telecom.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Le matricule est obligatoire")
    private String matricule;
    
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String motDePasse;
    
    // Constructeurs, getters, setters
    public LoginRequest() {}
    
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
}