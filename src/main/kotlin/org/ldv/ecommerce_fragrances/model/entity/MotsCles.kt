package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*
@Entity
class MotsCles(@Id
               @GeneratedValue(strategy = GenerationType.IDENTITY)
               @Column(nullable = false)

    var idMotsCles: Long,
    var nom: String,
    var couleur: String,
//Association Many to Many avec Produit
               @ManyToMany
               @JoinTable(
                   name = "mots_cles_produit",
                   joinColumns = [JoinColumn(name = "mots_cles_id")],
                   inverseJoinColumns = [JoinColumn(name = "produit_id")]
               )
               var produit: MutableList<Produit> = mutableListOf()
    ) {
}