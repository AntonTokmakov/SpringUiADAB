package com.example.springuiadab.services;

import com.example.springuiadab.entities.Product;
import com.example.springuiadab.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    private ProductRepositories productRepositories;

    @Autowired
    public void setProductRepositories(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    public List<Product> getAllProduct(){
        return productRepositories.getProducts();
    }

    public Product getProductById(Long id){
        return productRepositories.getProducts().get(id.intValue() - 1);
    }

    public void deleteProductById(Long id){
        productRepositories.deleteById(id);
    }

}
