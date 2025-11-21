package org.ldv.ecommerce_fragrances.controller.adminControllers

import org.ldv.ecommerce_fragrances.model.dao.CategorieDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminCategorieController{
    val categorieDAO: CategorieDAO
    get() {
            TODO()
        }
    @GetMapping("/e-commerce/admin/categories")
    fun index(model: Model):String {
        val categories = categorieDAO.findAll()
        model.addAttribute("categories", categories)
        return "pageAdmin/categorie/index"
    }

}