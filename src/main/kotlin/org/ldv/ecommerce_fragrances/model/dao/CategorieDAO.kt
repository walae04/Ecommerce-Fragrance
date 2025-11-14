package org.ldv.ecommerce_fragrances.model.dao
import org.ldv.ecommerce_fragrances.model.entity.Categorie
import org.springframework.data.jpa.repository.JpaRepository

interface CategorieDAO : JpaRepository<Categorie, Long> {
}
