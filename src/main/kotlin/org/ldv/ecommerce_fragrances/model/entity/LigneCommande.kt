package org.ldv.ecommerce_fragrances.model.entity

import jakarta.persistence.*
@Entity
class LigneCommande( @EmbeddedId
                     var quantiteId: QuantiteCommandeID? = null,
                     var quantite: Int,



                     @MapsId("produitId")
                     @ManyToOne
                     @JoinColumn(name = "produit_id")
                     var produit: Produit? = null,


                     @MapsId("commandeId")
                     @ManyToOne
                     @JoinColumn(name = "commande_id")
                     var commande: Commande? = null
,) {
}