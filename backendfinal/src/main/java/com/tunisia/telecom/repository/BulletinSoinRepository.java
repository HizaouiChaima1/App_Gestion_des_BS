package com.tunisia.telecom.repository;

import com.tunisia.telecom.entity.BulletinSoin;
import com.tunisia.telecom.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BulletinSoinRepository extends JpaRepository<BulletinSoin, Long> {
    
    List<BulletinSoin> findByEmployeOrderByDateCreationDesc(Employe employe);
    
    // NOUVELLE MÉTHODE : Trouver un bulletin par ID et employé
    Optional<BulletinSoin> findByIdAndEmploye(Long id, Employe employe);
    
    // NOUVELLE MÉTHODE : Compter les bulletins d'un employé
    long countByEmploye(Employe employe);
}