package com.example.Controller;

import com.example.Entity.Book;
import com.example.Entity.Utilisateur;
import com.example.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String adresse;

 
     

    @OneToMany(mappedBy = "utilisateur")
    private List<Book> livres;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.obtenirTousLesUtilisateurs();
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.obtenirUtilisateurParId(id);
    }

    @PostMapping
    public String addUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.enregistrerUtilisateur(utilisateur);
        return "Utilisateur ajouté avec succès";
    }

    @PutMapping("/{id}")
    public String updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur updatedUtilisateur) {
        Utilisateur existingUtilisateur = utilisateurService.obtenirUtilisateurParId(id);
        if (existingUtilisateur != null) {
            existingUtilisateur.setNom(updatedUtilisateur.getNom());
            existingUtilisateur.setPrenom(updatedUtilisateur.getPrenom());
            existingUtilisateur.setAdresse(updatedUtilisateur.getAdresse());
            utilisateurService.enregistrerUtilisateur(existingUtilisateur);
            return "Utilisateur avec ID " + id + " mis à jour avec succès";
        } else {
            return "Utilisateur avec ID " + id + " non trouvé";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUtilisateur(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.obtenirUtilisateurParId(id);
        if (utilisateur != null) {
            utilisateurService.supprimerUtilisateur(id);
            return "Utilisateur avec ID " + id + " supprimé avec succès";
        } else {
            return "Utilisateur avec ID " + id + " non trouvé";
        }
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}


