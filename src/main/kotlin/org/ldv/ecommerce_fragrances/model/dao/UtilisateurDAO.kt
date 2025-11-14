package org.ldv.ecommerce_fragrances.model.dao
import org.ldv.ecommerce_fragrances.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository

interface UtilisateurDAO: JpaRepository<Utilisateur, Long> {
}