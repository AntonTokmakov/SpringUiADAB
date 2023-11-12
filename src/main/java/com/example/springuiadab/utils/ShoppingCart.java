package com.example.springuiadab.utils;

import com.example.springuiadab.entities.Product;
import com.example.springuiadab.services.ProductServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

    private List<Product> products;
    private ProductServices productServices;

    @Autowired
    public void setProductServices(ProductServices productServices) {
        this.productServices = productServices;
    }

    public List<Product> getProducts(){
        return products;
    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
    }

    public void addProductById(Long id){
        Product product = productServices.getProductById(id);
        products.add(product);
    }

}
