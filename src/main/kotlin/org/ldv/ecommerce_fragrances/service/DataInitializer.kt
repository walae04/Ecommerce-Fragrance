package org.ldv.ecommerce_fragrances.service
import org.ldv.ecommerce_fragrances.model.dao.CategorieDAO
import org.ldv.ecommerce_fragrances.model.dao.CommandeDAO
import org.ldv.ecommerce_fragrances.model.dao.CommentaireDAO
import org.ldv.ecommerce_fragrances.model.dao.MotsClesDAO
import org.ldv.ecommerce_fragrances.model.dao.PaiementDao
import org.ldv.ecommerce_fragrances.model.dao.ProduitDAO
import org.ldv.ecommerce_fragrances.model.dao.RoleDAO
import org.ldv.ecommerce_fragrances.model.dao.UtilisateurDAO
import org.ldv.ecommerce_fragrances.model.entity.Categorie
import org.ldv.ecommerce_fragrances.model.entity.Commentaire
import org.ldv.ecommerce_fragrances.model.entity.MotsCles
import org.ldv.ecommerce_fragrances.model.entity.Produit
import org.ldv.ecommerce_fragrances.model.entity.Role
import org.ldv.ecommerce_fragrances.model.entity.Utilisateur
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val categorieDAO: CategorieDAO,
    private val produitDAO: ProduitDAO,
    private val commandeDAO: CommandeDAO,
    private val commentaireDAO: CommentaireDAO,
    private val motsClesDAO: MotsClesDAO,
    private val paiementDao: PaiementDao,
    private val roleDAO: RoleDAO,
    private val utilisateurDAO: UtilisateurDAO,
    val passwordEncoder: PasswordEncoder,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        // ROLE
        val roleAdmin = Role(
            nom = "ADMIN"
        )

        val roleClient = Role(
            nom = "CLIENT"
        )
        roleDAO.saveAll(listOf(roleAdmin, roleClient))
        val admin = Utilisateur(
            idUser = null,
            nom = "Super",
            prenom = "Admin",
            email = "admin@admin.com",
            mdp = passwordEncoder.encode("admin123"),// mot de passe hashé
            role = roleAdmin
        )
        val client = Utilisateur(
            idUser = null,
            nom = "Jean",
            prenom = "Client",
            email = "client@client.com",
            mdp = passwordEncoder.encode("client123"), // mot de passe hashé
            role = roleClient
        )
        utilisateurDAO.saveAll(listOf(admin, client))
        // Vérifie si la base contient déjà des données
        if (categorieDAO.count() > 0 || produitDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données...")

        // === Catégories ===

        val catParfums = Categorie(titre = "parfums")
        val catBrumes = Categorie(titre = "brumes")
        val catBougies = Categorie(titre = "bougies")

        categorieDAO.saveAll(listOf(catParfums, catBrumes, catBougies))

        // === Produits ===

        val produit1 = Produit(
            nom = "spirit n°1",
            description = "numéro 1 de notre collection de parfums",
            prix= 250.60,
            imgProduit = "https://example.com/images/montre-connectee.jpg",
            categories = catParfums.titre
        )

        val produit2 = Produit(
            nom = "spirit n°1",
            description = "numéro 1 de notre collection de brumes",
            prix= 120.99,
            imgProduit = "https://example.com/images/montre-connectee.jpg",
            categories = catBrumes.titre
        )


        // === Sauvegarde des Produits ===
        produitDAO.saveAll(
            listOf(
                produit1,
                produit2,
                )
        )

        println("✅ Données initiales insérées : ${categorieDAO.count()} catégories, ${produitDAO.count()} Produits.")
    }
}
//
