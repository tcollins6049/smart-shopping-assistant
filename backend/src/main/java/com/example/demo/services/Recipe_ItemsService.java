package com.example.demo.services;

import com.example.demo.models.Recipe_Items;
import com.example.demo.repositories.Recipe_ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing operations related to the Recipe_Items table
 * Acts as intermediary between the controller and repository.
 */
@Service
public class Recipe_ItemsService {
    
    @Autowired
    private Recipe_ItemsRepository recipe_itemsRepository;

    /**
     * Retrieves all recipe items for a specific recipe
     * 
     * @param recipe_id The ID of the recipe
     * @return List of recipe items associated with the recipe
     */
    public List<Recipe_Items> findAllRecipeItems(Long recipe_id) {
        return recipe_itemsRepository.findAllRecipeItems(recipe_id);
    }

    /**
     * Finds a single recipe item based on its id
     * 
     * @param id The ID of the recipe item
     * @return The matching Recipe_Item, or null if not found
     */
    public Recipe_Items findRecipeItem(Long id) {
        Optional<Recipe_Items> optionalItem = recipe_itemsRepository.findById(id);
        return optionalItem.orElse(null);
    }

    /**
     * Inserts a new recipe into the database.
     * 
     * @param recipe_item The Recipe_Item to insert
     */
    public void insertRecipeItem(Recipe_Items recipe_item) {
        recipe_itemsRepository.insert(recipe_item);
    }

    /**
     * Deletes an existing recipe from the database
     * 
     * @param recipe_item The Recipe_Item to delete
     */
    public void deleteRecipeItem(Recipe_Items recipe_item) {
        recipe_itemsRepository.delete(recipe_item);
    }

    /**
     * Gets the next available ID for inserting to use when inserting a new recipe
     * 
     * @return The next ID
     */
    public Long getNextId() {
        return recipe_itemsRepository.getNextId();
    }
}
