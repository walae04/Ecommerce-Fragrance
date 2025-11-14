package org.ldv.ecommerce_fragrances.model.dao
import org.ldv.ecommerce_fragrances.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO: JpaRepository<Role, Long> {
}