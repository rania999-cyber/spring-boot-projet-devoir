package com.example.ClassNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice
public class CustomErrorController {

    @RequestMapping("/error")
    public String handleError(Model model) {
        // Ajouter les détails de l'erreur au modèle
        // Vous pouvez ajouter d'autres détails si nécessaire
        model.addAttribute("error", "Sorry, something went wrong. Please try again later.");
        
        // Rediriger vers la page d'erreur personnalisée
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        // Ajouter les détails de l'erreur au modèle
        model.addAttribute("error", ex.getMessage());
        
        // Rediriger vers la page d'erreur personnalisée
        return "error";
    }
}

