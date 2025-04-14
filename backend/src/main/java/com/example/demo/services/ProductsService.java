package com.example.demo.services;

import com.example.demo.models.Products;
import com.example.demo.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing operations related to the products table
 * Acts as intermediary between the controller and repository.
 */
@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    /**
     * Retrieves  all products from the database.
     * 
     * @return List of all products
     */
    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    /**
     * Finds a product using its name
     * 
     * @param name The name of the product
     * @return The matching product, or null if not found
     */
    public Products findProductByName(String name) {
        Optional<Products> optionalProduct = productsRepository.findByName(name);
        return optionalProduct.orElse(null);
    }

    /**
     * Finds a product by its ID
     * 
     * @param id The ID of the product
     * @return The matching product, or null if not found
     */
    public Products findProductById(Long id) {
        Optional<Products> optionalProduct = productsRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    /**
     * Inserts a new product into the database
     * 
     * @param product The product to insert
     */
    public void insertProduct(Products product) {
        productsRepository.insert(product);
    }

    /**
     * Deletes an existing product from the database
     * 
     * @param product The product to delete
     */
    public void deleteProduct(Products product) {
        productsRepository.delete(product);
    }
}
