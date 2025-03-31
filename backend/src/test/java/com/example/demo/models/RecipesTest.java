package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipesTest {
    
    private Recipes recipes;

    @BeforeEach
    public void setUp() {
        recipes = new Recipes(1L, "Recipe name", "Recipe description", 3L);
    }

    // Accessor Tests
    @Test
    public void testGetId() {
        assertEquals(1L, recipes.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Recipe name", recipes.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Recipe description", recipes.getDescription());
    }

    @Test
    public void testGetUser_id() {
        assertEquals(3L, recipes.getUser_id());
    }

    // Mutator Tests
    @Test
    public void testSetId() {
        recipes.setId(2L);
        assertEquals(2L, recipes.getId());
    }

    @Test
    public void testSetName() {
        recipes.setName("Changed name");
        assertEquals("Changed name", recipes.getName());
    }

    @Test
    public void testSetDescription() {
        recipes.setDescription("Changed description");
        assertEquals("Changed description", recipes.getDescription());
    }

    @Test
    public void testSetUser_id() {
        recipes.setUser_id(4L);
        assertEquals(4L, recipes.getUser_id());
    }
}
