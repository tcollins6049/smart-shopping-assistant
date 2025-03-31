package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Recipe_ItemsTest {
    
    private Recipe_Items recipe_items;

    @BeforeEach
    public void setUp() {
        recipe_items = new Recipe_Items(1L, 3L, 5L, 10);
    }

    // Accessor Tests
    @Test
    public void testGetId() {
        assertEquals(1L, recipe_items.getId());
    }

    @Test
    public void testGetRecipe_id() {
        assertEquals(3L, recipe_items.getRecipe_id());
    }

    @Test
    public void testGetProduct_id() {
        assertEquals(5L, recipe_items.getProduct_id());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(10, recipe_items.getQuantity());
    }

    // Mutator Tests
    @Test
    public void testSetId() {
        recipe_items.setId(2L);
        assertEquals(2L, recipe_items.getId());
    }

    @Test
    public void testSetRecipe_id() {
        recipe_items.setRecipe_id(4L);
        assertEquals(4L, recipe_items.getRecipe_id());
    }

    @Test
    public void testSetProduct_id() {
        recipe_items.setProduct_id(6L);
        assertEquals(6L, recipe_items.getProduct_id());
    }

    @Test
    public void testSetQuantity() {
        recipe_items.setQuantity(12);
        assertEquals(12, recipe_items.getQuantity());
    }
}
