package com.tunisia.telecom.controller;


import com.tunisia.telecom.entity.BulletinSoin;
import com.tunisia.telecom.service.BulletinSoinService;
import com.tunisia.telecom.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/bulletins")
@CrossOrigin(origins = "http://localhost:4200")
public class BulletinSoinController {
    
    @Autowired
    private BulletinSoinService bulletinSoinService;
    
    @Autowired
    private JwtUtils jwtUtils;
    
    @PostMapping
  //  @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> creerBulletin(@Valid @RequestBody BulletinSoin bulletin, 
                                          HttpServletRequest request) {
        try {
            String matricule = getMatriculeFromToken(request);
            BulletinSoin nouveauBulletin = bulletinSoinService.creerBulletin(bulletin, matricule);
            return ResponseEntity.ok(nouveauBulletin);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur: " + e.getMessage());
        }
    }
    
    @GetMapping("/mes-bulletins")
   // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<BulletinSoin>> getMesBulletins(HttpServletRequest request) {
        String matricule = getMatriculeFromToken(request);
        List<BulletinSoin> bulletins = bulletinSoinService.getBulletinsByEmploye(matricule);
        return ResponseEntity.ok(bulletins);
    }
    
    @GetMapping
  //  @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<BulletinSoin>> getAllBulletins() {
        List<BulletinSoin> bulletins = bulletinSoinService.getAllBulletins();
        return ResponseEntity.ok(bulletins);
    }
    
    @GetMapping("/{id}")
 //   @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getBulletinById(@PathVariable Long id) {
        try {
            BulletinSoin bulletin = bulletinSoinService.getBulletinById(id);
            return ResponseEntity.ok(bulletin);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateBulletin(@PathVariable Long id, 
                                           @Valid @RequestBody BulletinSoin bulletin) {
        try {
            BulletinSoin updated = bulletinSoinService.updateBulletin(id, bulletin);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteBulletin(@PathVariable Long id) {
        try {
            bulletinSoinService.deleteBulletin(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur: " + e.getMessage());
        }
    }
    
    private String getMatriculeFromToken(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            String jwt = headerAuth.substring(7);
            return jwtUtils.getUsernameFromJwtToken(jwt);
        }
        throw new RuntimeException("Token non trouvé");
    }
}