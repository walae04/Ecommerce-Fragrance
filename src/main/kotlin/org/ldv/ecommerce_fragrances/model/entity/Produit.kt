package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*
@Entity
class Produit(@Id
              @GeneratedValue(strategy = GenerationType.IDENTITY)
              @Column(nullable = false)

    var idProduit: Long,
    var nom: String,
    var description: String,
    var prix: Double,
    var imgProduit: String,
    var categories: String,
//Association avec Commentaire
@OneToMany(mappedBy = "produit",cascade = [CascadeType.ALL], orphanRemoval = true)
var commentaire: MutableList<Commentaire> = mutableListOf(),
//Association avec Categorie (Produit est le maitre de l'association)'
          @ManyToOne
          @JoinColumn(name = "categorie_fk_id")
          var categorie: Categorie ? = null,

//Association Many to Many avec motsCles
          @ManyToMany(mappedBy = "produit")
          var motsCles: MutableList<MotsCles> = mutableListOf()

) {
}