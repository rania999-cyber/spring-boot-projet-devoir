package com.example.Service;

import com.example.Entity.Utilisateur;
import com.example.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Enregistrer un nouvel utilisateur dans la base de données
    @Override
    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Récupérer un utilisateur par son ID
    @Override
    public Utilisateur obtenirUtilisateurParId(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    // Récupérer la liste de tous les utilisateurs dans la base de données
    @Override
    public List<Utilisateur> obtenirTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Supprimer un utilisateur par son ID
    @Override
    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}


