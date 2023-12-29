package com.example.Service;

import com.example.Entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    // Enregistrer un nouvel utilisateur
    Utilisateur enregistrerUtilisateur(Utilisateur utilisateur);

    // Récupérer un utilisateur par son ID
    Utilisateur obtenirUtilisateurParId(Long id);

    // Récupérer la liste de tous les utilisateurs
    List<Utilisateur> obtenirTousLesUtilisateurs();

    // Supprimer un utilisateur par son ID
    void supprimerUtilisateur(Long id);
}
