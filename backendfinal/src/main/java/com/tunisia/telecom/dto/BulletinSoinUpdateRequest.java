package com.tunisia.telecom.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BulletinSoinUpdateRequest {
    
    @NotNull(message = "La date du soin est obligatoire")
    private LocalDate dateSoin;
    
    @NotBlank(message = "Le type de soin est obligatoire")
    @Size(max = 100, message = "Le type de soin ne peut pas dépasser 100 caractères")
    private String typeSoin;
    
    @Size(max = 1000, message = "La description ne peut pas dépasser 1000 caractères")
    private String description;
    
    @NotBlank(message = "Le nom du médecin est obligatoire")
    @Size(max = 100, message = "Le nom du médecin ne peut pas dépasser 100 caractères")
    private String nomMedecin;
    
    @DecimalMin(value = "0.0", message = "Le coût doit être positif")
    private BigDecimal cout;
    
    // Constructeurs
    public BulletinSoinUpdateRequest() {}
    
    // Getters et Setters
    public LocalDate getDateSoin() { return dateSoin; }
    public void setDateSoin(LocalDate dateSoin) { this.dateSoin = dateSoin; }
    
    public String getTypeSoin() { return typeSoin; }
    public void setTypeSoin(String typeSoin) { this.typeSoin = typeSoin; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }
    
    public BigDecimal getCout() { return cout; }
    public void setCout(BigDecimal cout) { this.cout = cout; }
}