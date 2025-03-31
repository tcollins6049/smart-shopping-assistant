package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductsTest {

     private Products products;

     @BeforeEach
     public void setUp() {
        products = new Products(1L, "Test Product", "This is a test product");
     }

     // Tests for Getters
     @Test
     public void testGetId() {
        assertEquals(1L, products.getId());
     }

     @Test
     public void testGetName() {
        assertEquals("Test Product", products.getName());
     }

     @Test
     public void testGetDescription() {
        assertEquals("This is a test product", products.getDescription());
     }


     // Tests for Setters
     @Test
     public void testSetId() {
        products.setId(2L);
        assertEquals(2L, products.getId());
     }

     @Test
     public void testSetName() {
        products.setName("Updated Product");
        assertEquals("Updated Product", products.getName());
     }

     @Test
     public void testSetDescription() {
        products.setDescription("This is an updated test product");
        assertEquals("This is an updated test product", products.getDescription());
     }
}
