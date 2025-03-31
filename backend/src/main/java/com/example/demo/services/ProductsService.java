package com.example.demo.services;

import com.example.demo.models.Products;
import com.example.demo.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    // Method to get all products
    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    public Products findProductByName(String name) {
        Optional<Products> optionalProduct = productsRepository.findByName(name);
        return optionalProduct.orElse(null);
    }

    public Products findProductById(Long id) {
        Optional<Products> optionalProduct = productsRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public void insertProduct(Products product) {
        productsRepository.insert(product);
    }

    public void deleteProduct(Products product) {
        productsRepository.delete(product);
    }
}
