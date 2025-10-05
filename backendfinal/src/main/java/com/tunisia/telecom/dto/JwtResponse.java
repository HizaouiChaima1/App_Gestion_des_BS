package com.tunisia.telecom.dto;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    
    public JwtResponse(String token, String matricule, String nom, String prenom, String email) {
        this.token = token;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    
    // Getters et setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
