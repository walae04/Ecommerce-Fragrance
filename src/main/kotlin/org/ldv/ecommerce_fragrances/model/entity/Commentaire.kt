package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*
@Entity
class Commentaire(@Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  @Column(nullable = false)

    var idCommentaire: Long,
    var idUser: Long,
    var idProduit: Long,
    var texte: String,
    var dateCommentaire: String,
    //Association avec Utilisateur (Commentaire est le maitre de l'association)'
                  @ManyToOne
                  @JoinColumn(name = "utilisateur_fk_id")
                  var utilisateur: Utilisateur ? = null,
    //Association avec Produit (Commentaire est le maitre de l'association)'
                  @ManyToOne
                  @JoinColumn(name = "prduit_fk_id")
                  var produit: Produit ? = null
    ) {
}