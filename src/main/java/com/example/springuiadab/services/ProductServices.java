package com.example.springuiadab.services;

import com.example.springuiadab.entities.Product;
import com.example.springuiadab.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepositories(ProductRepository productRepositories) {
        this.productRepository = productRepositories;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.getOne(id - 1);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

}
