package org.ldv.ecommerce_fragrances.controller.adminControllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
@Controller
class AdminCotroller {
    @GetMapping("e-commerce/admin")
    fun accueil():String = "pageAdmin/dashboard"
}