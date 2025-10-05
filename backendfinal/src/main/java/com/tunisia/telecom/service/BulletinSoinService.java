package com.tunisia.telecom.service;


import com.tunisia.telecom.entity.BulletinSoin;
import com.tunisia.telecom.entity.Employe;
import com.tunisia.telecom.repository.BulletinSoinRepository;
import com.tunisia.telecom.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BulletinSoinService {
    
    @Autowired
    private BulletinSoinRepository bulletinSoinRepository;
    
    @Autowired
    private EmployeRepository employeRepository;
    
    public BulletinSoin creerBulletin(BulletinSoin bulletin, String matricule) {
        Employe employe = employeRepository.findByMatricule(matricule)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
        
        bulletin.setEmploye(employe);
        return bulletinSoinRepository.save(bulletin);
    }
    
    public List<BulletinSoin> getBulletinsByEmploye(String matricule) {
        Employe employe = employeRepository.findByMatricule(matricule)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
        
        return bulletinSoinRepository.findByEmployeOrderByDateCreationDesc(employe);
    }
    
    public List<BulletinSoin> getAllBulletins() {
        return bulletinSoinRepository.findAll();
    }
    
    public BulletinSoin getBulletinById(Long id) {
        return bulletinSoinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bulletin non trouvé"));
    }
    
    public BulletinSoin updateBulletin(Long id, BulletinSoin bulletin) {
        BulletinSoin existant = getBulletinById(id);
        existant.setDateSoin(bulletin.getDateSoin());
        existant.setTypeSoin(bulletin.getTypeSoin());
        existant.setDescription(bulletin.getDescription());
        existant.setNomMedecin(bulletin.getNomMedecin());
        existant.setCout(bulletin.getCout());
        
        return bulletinSoinRepository.save(existant);
    }
    
    public void deleteBulletin(Long id) {
        bulletinSoinRepository.deleteById(id);
    }
}