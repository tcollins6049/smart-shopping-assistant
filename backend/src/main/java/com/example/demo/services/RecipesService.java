package com.example.demo.services;

import com.example.demo.models.Recipes;
import com.example.demo.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipesService {
    
    @Autowired
    private RecipesRepository recipesRepository;

    // Get all recipes based off user_id
    public List<Recipes> findAllUserRecipes(Long user_id) {
        return recipesRepository.findAllRecipes(user_id);
    }

    // Find receipe off of recipe id
    public Recipes findRecipe(Long id) {
        Optional<Recipes> optionalRecipe = recipesRepository.findById(id);
        return optionalRecipe.orElse(null);
    }

    // Insert into Recipes table
    public void insertRecipe(Recipes recipe) {
        recipesRepository.insert(recipe);
    }

    // Delete from Recipes table
    public void deleteRecipe(Recipes recipe) {
        recipesRepository.delete(recipe);
    }

    // Find next id
    public Long getNextId() {
        return recipesRepository.getNextId();
    }
}
