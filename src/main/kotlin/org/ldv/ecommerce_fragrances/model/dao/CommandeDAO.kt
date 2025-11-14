package org.ldv.ecommerce_fragrances.model.dao
import org.ldv.ecommerce_fragrances.model.entity.Commande
import org.springframework.data.jpa.repository.JpaRepository
interface CommandeDAO: JpaRepository<Commande, Long>  {
}