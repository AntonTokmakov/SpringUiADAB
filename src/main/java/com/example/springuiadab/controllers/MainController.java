package com.example.springuiadab.controllers;

import com.example.springuiadab.entities.Product;
import com.example.springuiadab.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    private ProductServices productServices;

    @Autowired
    public void setProductServices(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/")
    public String homepage(){
        return "index";
    }

    @GetMapping("/shop")
    public String shopPage(Model model){

        List<Product> products = productServices.getAllProduct();

        model.addAttribute("products", products);

        return "shop";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id){

        Product selectedProduct = productServices.getProductById(id);

        model.addAttribute("products", selectedProduct);

        return "details";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){

        productServices.deleteProductById(id);
        return "redirect:/shop";

    }

}
