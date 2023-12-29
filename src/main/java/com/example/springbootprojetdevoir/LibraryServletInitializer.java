package com.example.springbootprojetdevoir;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Initialisateur de la servlet DispatcherServlet pour la configuration de Spring MVC
public class LibraryServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Configuration des classes de configuration racine (root context)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringBootProjetDevoirApplication.class, SecurityConfig.class};
    }

    // Configuration des classes de configuration de la servlet DispatcherServlet
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // Aucune configuration spécifique de la servlet DispatcherServlet
    }

    // Mappage des URL pour la servlet DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // Toutes les URL sont gérées par la servlet DispatcherServlet
    }
}
