package com.example.demo.repositories;

import com.example.demo.models.Recipes;
import com.example.demo.models.Users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;


@SpringBootTest(classes = {com.example.demo.SmartShoppingAssistantApplication.class})
public class RecipesRepoTest {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RecipesRepository recipesRepository;

    @Autowired
    private UsersRepository usersRepository;


    @Test
    void testInsertDeleteRecipe() {
        // Create user (Foregin Key)
        Users new_user = new Users(0L, "Test Username", "Test Password");
        usersRepository.insert(new_user);

        // Create and insert recipe
        Recipes new_recipe = new Recipes(1L, "Test Recipe", "Test Description", 0L);
        recipesRepository.insert(new_recipe);

        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Recipes WHERE id = ? AND name = ?",
            Integer.class, new_recipe.getId(), new_recipe.getName());
        assertEquals(1, count.intValue(), "The recipe was successfully inserted");

        recipesRepository.delete(new_recipe);
        usersRepository.delete(new_user);
    }

    @Test
    void testFindRecipes() {
        // Create user (Foregin Key)
        Users new_user = new Users(0L, "Test Username", "Test Password");
        usersRepository.insert(new_user);

        // Create and insert recipe
        Recipes new_recipe = new Recipes(1L, "Test Recipe", "Test Description", 0L);
        recipesRepository.insert(new_recipe);

        // Find all
        List<Recipes> recipes = recipesRepository.findAllRecipes(new_user.getId());
        
        // Ensure list only contains one recipe
        assertEquals(1, recipes.size());

        // Ensure recipe details are correct
        Recipes retrieved_recipe = recipes.get(0);
        assertEquals(new_recipe.getId(), retrieved_recipe.getId());
        assertEquals(new_recipe.getName(), retrieved_recipe.getName());
        assertEquals(new_recipe.getDescription(), retrieved_recipe.getDescription());
        assertEquals(new_recipe.getUser_id(), retrieved_recipe.getUser_id());
    
        // Clean up
        recipesRepository.delete(new_recipe);
        usersRepository.delete(new_user);
    }
}
