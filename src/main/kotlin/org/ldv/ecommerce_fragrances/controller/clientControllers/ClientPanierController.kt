package org.ldv.ecommerce_fragrances.controller.clientControllers
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@SessionAttributes("panier")
class ClientPanierController {

    // Initialise le panier en session (liste d'IDs)
    @ModelAttribute("panier")
    fun initPanier(): MutableList<Long> {
        return mutableListOf()
    }

    // ➕ Ajouter au panier
    @PostMapping("/e-commerce/panier/add")
    fun addToCart(
        @RequestParam idProduit: Long,
        @ModelAttribute("panier") panier: MutableList<Long>,
        redirectAttributes: RedirectAttributes
    ): String {

        panier.add(idProduit)

        // Message affiché après redirection
        redirectAttributes.addFlashAttribute("message", "Produit ajouté au panier !")

        return "redirect:/e-commerce/panier"
    }
}
