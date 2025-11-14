package org.ldv.ecommerce_fragrances.model.dao
import org.ldv.ecommerce_fragrances.model.entity.Paiement
import org.springframework.data.jpa.repository.JpaRepository

interface PaiementDao: JpaRepository<Paiement, Long> {
}