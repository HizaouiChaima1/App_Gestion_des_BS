package com.tunisia.telecom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bulletins_soins")
public class BulletinSoin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @NotNull(message = "La date du soin est obligatoire")
    private LocalDate dateSoin;
    
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Le type de soin est obligatoire")
    @Size(max = 100, message = "Le type de soin ne peut pas dépasser 100 caractères")
    private String typeSoin;
    
    @Column(columnDefinition = "TEXT")
    @Size(max = 1000, message = "La description ne peut pas dépasser 1000 caractères")
    private String description;
    
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Le nom du médecin est obligatoire")
    @Size(max = 100, message = "Le nom du médecin ne peut pas dépasser 100 caractères")
    private String nomMedecin;
    
    @Column(precision = 10, scale = 2)  // ✅ This works with BigDecimal
    private BigDecimal cout;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatutBulletin statut = StatutBulletin.EN_ATTENTE;
    
    @Column(nullable = false)
    private LocalDateTime dateCreation = LocalDateTime.now();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;
    
    // Enum pour le statut
    public enum StatutBulletin {
        EN_ATTENTE, APPROUVE, REJETE
    }
    
    // Constructeurs
    public BulletinSoin() {}
    
    public BulletinSoin(LocalDate dateSoin, String typeSoin, String description, 
                       String nomMedecin, BigDecimal cout, Employe employe) {
        this.dateSoin = dateSoin;
        this.typeSoin = typeSoin;
        this.description = description;
        this.nomMedecin = nomMedecin;
        this.cout = cout;
        this.employe = employe;
    }
    
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDate getDateSoin() { return dateSoin; }
    public void setDateSoin(LocalDate dateSoin) { this.dateSoin = dateSoin; }
    
    public String getTypeSoin() { return typeSoin; }
    public void setTypeSoin(String typeSoin) { this.typeSoin = typeSoin; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }
    
    public BigDecimal getCout() { return cout; }
    public void setCout(BigDecimal double1) { this.cout = double1; }
    
    public StatutBulletin getStatut() { return statut; }
    public void setStatut(StatutBulletin statut) { this.statut = statut; }
    
    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }
    
    public Employe getEmploye() { return employe; }
    public void setEmploye(Employe employe) { this.employe = employe; }
}