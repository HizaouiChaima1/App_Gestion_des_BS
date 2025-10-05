package com.tunisia.telecom.repository;

import com.tunisia.telecom.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    
    Optional<Employe> findByMatricule(String matricule);
    
    Optional<Employe> findByEmail(String email);
    
    boolean existsByMatricule(String matricule);
    
    boolean existsByEmail(String email);
}
