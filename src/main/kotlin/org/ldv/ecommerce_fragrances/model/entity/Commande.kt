package org.ldv.ecommerce_fragrances.model.entity

import java.time.LocalDate
import jakarta.persistence.*
@Entity
class Commande(@Id
               @GeneratedValue(strategy = GenerationType.IDENTITY)
               @Column(nullable = false)

    var idCommande: Long,
    var dateCommande: LocalDate,
    var statut: String,
    var montantTotal: Double,
//Association one to one avec paiement
               @OneToOne
               @JoinColumn(name = "paiement_fk_id")
               var paiement: Paiement? = null



) {
}