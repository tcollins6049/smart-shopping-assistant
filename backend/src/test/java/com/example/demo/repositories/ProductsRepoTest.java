package com.example.demo.repositories;

import com.example.demo.models.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;


@SpringBootTest(classes = {com.example.demo.SmartShoppingAssistantApplication.class})
public class ProductsRepoTest {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductsRepository productsRepository;

    @Test
    void testFindAll() {
        List<Products> products = productsRepository.findAll();
        assertNotNull(products);
    }


    @Test
    void testInsertDeleteProduct() {
        // Create and insert a new product
        Products new_product = new Products(null, "Product1", "Description1");
        productsRepository.insert(new_product);

        // Verify the product was inserted
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM products WHERE name = ? AND CAST(description AS NVARCHAR(MAX)) = ?",
            Integer.class, new_product.getName(), new_product.getDescription());
        assertEquals(1, count.intValue(), "The product was successfully inserted");
    
        // Delete the product
        productsRepository.delete(new_product);
        
        count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM products WHERE name = ? AND CAST(description AS NVARCHAR(MAX)) = ?",
            Integer.class, new_product.getName(), new_product.getDescription());
        assertEquals(0, count.intValue(), "The product was deleted successfully");
    }
}
