package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*
@Entity
class Role(@Id
           @GeneratedValue(strategy = GenerationType.IDENTITY)
           @Column(nullable = false)

    var idRole: Long,
    var nom: String,
    //Association avec Utilisateur
           @OneToMany(mappedBy = "role",cascade = [CascadeType.ALL], orphanRemoval = true)
           var utilisateur: MutableList<Utilisateur> = mutableListOf()
) {
}