package com.example.Service;

import com.example.Entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur enregistrerUtilisateur(Utilisateur utilisateur);
    Utilisateur obtenirUtilisateurParId(Long id);
    List<Utilisateur> obtenirTousLesUtilisateurs();
    void supprimerUtilisateur(Long id);
}
