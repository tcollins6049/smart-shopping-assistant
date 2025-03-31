package com.example.demo.services;

import com.example.demo.models.Recipe_Items;
import com.example.demo.repositories.Recipe_ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Recipe_ItemsService {
    
    @Autowired
    private Recipe_ItemsRepository recipe_itemsRepository;

    // Find all recipe items based off the recipe_id
    public List<Recipe_Items> findAllRecipeItems(Long recipe_id) {
        return recipe_itemsRepository.findAllRecipeItems(recipe_id);
    }

    // Find recipe_item based off its id
    public Recipe_Items findRecipeItem(Long id) {
        Optional<Recipe_Items> optionalItem = recipe_itemsRepository.findById(id);
        return optionalItem.orElse(null);
    }

    // Insert into recipe_items table
    public void insertRecipeItem(Recipe_Items recipe_item) {
        recipe_itemsRepository.insert(recipe_item);
    }

    // Delete from recipe_items table
    public void deleteRecipeItem(Recipe_Items recipe_item) {
        recipe_itemsRepository.delete(recipe_item);
    }

    // Get next id
    public Long getNextId() {
        return recipe_itemsRepository.getNextId();
    }
}
