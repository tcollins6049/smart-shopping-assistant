package com.example.demo.repositories;

import com.example.demo.models.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Optional;
import java.util.List;

@Repository // Indicates that this is a Spring data repository
public class ProductsRepository implements RepositoryInterface<Products> {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all products in the Products table
    public List<Products> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Products.class));
    }

    // insert product into Products table
    @Override
    public void insert(Products product) {
        String sql = "INSERT INTO products (name, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getDescription());
    }

    // Delete product from Products table
    @Override
    public void delete(Products product) {
        String sql = "DELETE FROM products WHERE name = ? AND CAST(description AS NVARCHAR(MAX)) = ?";
        jdbcTemplate.update(sql, product.getName(), product.getDescription());
    }

    // Find entry in Products table by name
    public Optional<Products> findByName(String name) {
        String sql = "SELECT * FROM products WHERE name = ?";
        List<Products> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Products.class), name);
        if (products.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(products.get(0));
        }
    }

    // Find entry in Products table by id
    public Optional<Products> findById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Products> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Products.class), id);
        if (products.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(products.get(0));
        }
    }
}
