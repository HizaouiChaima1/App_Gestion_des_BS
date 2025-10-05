package com.tunisia.telecom.dto;

import jakarta.validation.constraints.*;

public class RegisterRequest {
    @NotBlank(message = "Le matricule est obligatoire")
    @Size(min = 3, max = 20)
    private String matricule;
    
    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 50)
    private String nom;
    
    @NotBlank(message = "Le prénom est obligatoire")
    @Size(max = 50)
    private String prenom;
    
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format d'email invalide")
    private String email;
    
    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    private String motDePasse;
    
    // Constructeurs, getters, setters
    public RegisterRequest() {}
    
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
}