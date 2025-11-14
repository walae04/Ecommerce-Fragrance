package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*
@Entity
class Paiement(@Id
               @GeneratedValue(strategy = GenerationType.IDENTITY)
               @Column(nullable = false)

    var idPaiement: Long,
    var idUser: Long,
    var modePaiement: String,
    var statut: String,
//Association one to one avec commande
@OneToOne(mappedBy = "paiement",cascade = [CascadeType.ALL], orphanRemoval = true)
var commande: Commande? = null
) {
}