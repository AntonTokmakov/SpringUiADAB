package com.example.springuiadab.repositories;

import com.example.springuiadab.entities.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositories {

    private List<Product> products;

    public List<Product> getProducts(){
        return products;
    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1L, "Milk", 80));
        products.add(new Product(2L, "Мяч", 80));
        products.add(new Product(3L, "Печенья", 80));
        products.add(new Product(4L, "Ноутбук", 80));
    }

    public Boolean deleteById(Long id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }
}
