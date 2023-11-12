package com.example.springuiadab.controllers;


import com.example.springuiadab.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private ShoppingCart shoppingCart;

    @Autowired
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @GetMapping("")
    public String showCart(Model model){

        model.addAttribute("products", shoppingCart.getProducts());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addProductById(@PathVariable Long id){

        shoppingCart.addProductById(id);

        return "redirect:/shop";
    }

}
