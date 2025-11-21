package org.ldv.ecommerce_fragrances.controller

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController (){
    /**
     * Méthode permettant d'afficher la page d'accueil de l'application.
     * @return le chemin vers le template à partir du dossier ressources/templates (on ne marque pas le .html)
     */
    @GetMapping("/e-commerce")
    fun home():String{
        return "index"

    }
    @GetMapping("/e-commerce/login")
    fun login(@RequestParam error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
        return "pageVisiteur/login"
    }
    @GetMapping("/e-commerce/profil")
    fun profile(authentication: Authentication): String {

        // Récupération des rôles (authorities) de l’utilisateur connecté
        val roles = authentication.authorities.map { it.authority }

        // Si l'utilisateur est admin → redirection
        if ("ROLE_ADMIN" in roles) {
            return "pageAdmin/dashboard"
        }

        // Sinon → on affiche la page profile
        return "pageClient/profile"
    }

}
