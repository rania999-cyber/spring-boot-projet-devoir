package com.example.Controller;

import com.example.Entity.Utilisateur;
import com.example.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs") // Définit le chemin de base pour toutes les requêtes dans ce contrôleur
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Endpoint pour récupérer tous les utilisateurs
    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.obtenirTousLesUtilisateurs();
    }

    // Endpoint pour récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.obtenirUtilisateurParId(id);
    }

    // Endpoint pour ajouter un nouvel utilisateur
    @PostMapping
    public String addUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.enregistrerUtilisateur(utilisateur);
        return "Utilisateur ajouté avec succès";
    }

    // Endpoint pour mettre à jour un utilisateur existant
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

    // Endpoint pour supprimer un utilisateur par son ID
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
}





