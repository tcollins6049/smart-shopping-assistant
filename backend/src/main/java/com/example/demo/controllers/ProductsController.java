package com.example.demo.controllers;

import com.example.demo.models.Products;
import com.example.demo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Class will handle HTTP requests and return JSON or XML responses
@RequestMapping("/api/products")    // Base url for all endpoints in controller
public class ProductsController {
    
    @Autowired  // Dependency injection for ProductsService
    private ProductsService productsService;

    @GetMapping // Maps HTTP GET requests to the getAllProducts method
    public List<Products> getAllProducts() {
        return productsService.findAllProducts();
    }

    @GetMapping("/{id}")    // Maps HTTP GET requests with an id path variable.
    public Products getProductById(@PathVariable Long id) {
        return productsService.findProductById(id);
    }

    @PostMapping    // Maps HTTP POST requests
    public void addProduct(@RequestBody Products product) {
        productsService.insertProduct(product);
    }

    @DeleteMapping("/{id}") // Maps HTTP POST requests with an id path variable.
    public void deleteProduct(@PathVariable Long id) {
        Products product = productsService.findProductById(id);
        if (product != null) {
            productsService.deleteProduct(product);
        }
    }
}
