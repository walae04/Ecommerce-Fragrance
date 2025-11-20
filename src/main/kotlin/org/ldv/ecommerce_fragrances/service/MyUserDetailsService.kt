package org.ldv.ecommerce_fragrances.service

import org.ldv.ecommerce_fragrances.model.dao.UtilisateurDAO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService (private val utilisateurDAO: UtilisateurDAO) : UserDetailsService {
    /**
     * Méthode appelée automatiquement par Spring Security lors
     * du login, afin de récupérer un utilisateur grâce à son username.
     *
     * @param username : ici il s'agit de l'email entré dans le formulaire/login
     * @return UserDetails : objet utilisé par Spring Security pour authentifier l'utilisateur.
     */
    override fun loadUserByUsername(username: String): UserDetails {

        /**
         * Récupération de l'utilisateur via son email (username).
         * Si aucun utilisateur n'est trouvé, on lance une exception attendue par Spring Security :
         * UsernameNotFoundException.
         */
        val utilisateur = utilisateurDAO.findByEmail(username)
            ?: throw UsernameNotFoundException("User not found")

        /**
         * Logique d'attribution du rôle.
         *
         * Version simple :
         * - on récupère le nom du rôle associé à l'utilisateur (ex: "ADMIN", "CLIENT").
         * - Ce rôle doit être une chaîne compatible avec Spring Security.
         */
        val leRole = utilisateur.role?.nom
        /**
         * Construction de l'objet UserDetails attendu par Spring Security.
         *
         * - .withUsername() = username utilisé pour se connecter
         * - .password()     = mot de passe stocké (DOIT être encodé en BCrypt ou autres)
         * - .roles()        = rôle(s) attribué(s)
         *
         * ⚠️ Attention :
         * Spring Security ajoute automatiquement "ROLE_" devant les rôles.
         * Exemple : roles("ADMIN") deviendra "ROLE_ADMIN"
         */
        return org.springframework.security.core.userdetails.User
            .withUsername(utilisateur.email)   // Identifiant de connexion
            .password(utilisateur.mdp)         // Mot de passe hashé
            .roles(leRole)                     // Rôle(s) attribué(s)
            .build()


    } }