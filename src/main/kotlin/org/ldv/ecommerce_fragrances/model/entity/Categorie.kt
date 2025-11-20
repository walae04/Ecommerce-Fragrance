package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*

@Entity

class Categorie(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Column(nullable = false)
    var idCategorie: Long? = null,
    var titre: String,
//Association avec Produit
            @OneToMany(mappedBy = "categorie",cascade = [CascadeType.ALL], orphanRemoval = true)
            var produit: MutableList<Produit> = mutableListOf()

    ) {
}