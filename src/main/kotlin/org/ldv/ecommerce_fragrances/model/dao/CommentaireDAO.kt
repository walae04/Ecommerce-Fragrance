package org.ldv.ecommerce_fragrances.model.dao
import org.ldv.ecommerce_fragrances.model.entity.Commentaire
import org.springframework.data.jpa.repository.JpaRepository

interface CommentaireDAO: JpaRepository<Commentaire, Long> {
}