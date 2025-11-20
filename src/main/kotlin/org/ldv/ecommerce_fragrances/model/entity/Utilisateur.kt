package org.ldv.ecommerce_fragrances.model.entity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Utilisateur (@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(nullable = false)
   var idUser:Long? = null,
    var prenom:String,
   var nom:String,
   var mdp:String,
   var email: String,
   @Column(nullable = false, updatable = false)
   var dateCreation: LocalDateTime = LocalDateTime.now(),
   @Column(nullable = false)
   var dateModification: LocalDateTime = LocalDateTime.now(),



//Association avec Role (Utilisateur est le maitre de l'association)'
@ManyToOne
@JoinColumn(name = "role_fk_id")
var role: Role? = null,

//Association avec Commentaire
@OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
var commentaire: MutableList<Commentaire> = mutableListOf()
)
{
    @PreUpdate
    fun preUpdate() {
        dateModification = LocalDateTime.now()
    }

}