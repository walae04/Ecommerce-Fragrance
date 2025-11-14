package org.ldv.ecommerce_fragrances.model.dao
import org.ldv.ecommerce_fragrances.model.entity.Produit
import org.springframework.data.jpa.repository.JpaRepository

interface ProduitDAO: JpaRepository<Produit, Long> {
}