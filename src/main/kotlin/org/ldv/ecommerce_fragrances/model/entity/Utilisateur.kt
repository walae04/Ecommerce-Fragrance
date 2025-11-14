package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*
@Entity
class Utilisateur (@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   @Column(nullable = false)

    var idUser:Long,
    var nom:String,
    var mdp:String,
    var email: String,
    var adresse: String,


//Association avec Role (Utilisateur est le maitre de l'association)'
@ManyToOne
@JoinColumn(name = "role_fk_id")
var role: Role? = null,

//Association avec Commentaire
@OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
var commentaire: MutableList<Commentaire> = mutableListOf()
)
{

}