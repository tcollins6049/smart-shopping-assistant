package com.example.demo.services;

import com.example.demo.models.Recipes;
import com.example.demo.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing operations related to the Recipes table
 * Acts as intermediary between the controller and repository.
 */
@Service
public class RecipesService {
    
    @Autowired
    private RecipesRepository recipesRepository;

    /**
     * Retreives all recipes belonging to a specific user given the user_id.
     * 
     * @param user_id The user's ID
     * @return A list of the user's recipes
     */
    public List<Recipes> findAllUserRecipes(Long user_id) {
        return recipesRepository.findAllRecipes(user_id);
    }

    /**
     * Finds a recipe by its ID
     * 
     * @param id The recipe id
     * @return The recipe, or null if not found
     */
    public Recipes findRecipe(Long id) {
        Optional<Recipes> optionalRecipe = recipesRepository.findById(id);
        return optionalRecipe.orElse(null);
    }

    /**
     * Inserts a new recipe into the database
     * 
     * @param recipe The recipe to insert
     */
    public void insertRecipe(Recipes recipe) {
        recipesRepository.insert(recipe);
    }

    /**
     * Deletes a recipe from the database
     * 
     * @param recipe The recipe to delete
     */
    public void deleteRecipe(Recipes recipe) {
        recipesRepository.delete(recipe);
    }

    /**
     * Gets the next available ID to use when inserting a new recipe
     * 
     * @return The next ID
     */
    public Long getNextId() {
        return recipesRepository.getNextId();
    }
}
