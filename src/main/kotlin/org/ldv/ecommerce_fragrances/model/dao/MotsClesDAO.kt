package org.ldv.ecommerce_fragrances.model.dao
import org.ldv.ecommerce_fragrances.model.entity.MotsCles
import org.springframework.data.jpa.repository.JpaRepository

interface MotsClesDAO: JpaRepository<MotsCles, Long> {
}