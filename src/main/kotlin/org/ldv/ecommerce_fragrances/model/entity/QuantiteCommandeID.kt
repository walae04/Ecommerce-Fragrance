package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*
import java.io.Serializable

@Embeddable
class QuantiteCommandeID(
                var produitId: Long,
                var commandeId: Long
): Serializable {
}