package com.example.demo.controllers;

import com.example.demo.models.Recipes;
import com.example.demo.services.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
    
    @Autowired
    private RecipesService recipesService;

    @GetMapping
    public Long getNextId() {
        return recipesService.getNextId();
    }

    @GetMapping("/user/{user_id}")
    public List<Recipes> findAllUserRecipes(@PathVariable Long user_id) {
        return recipesService.findAllUserRecipes(user_id);
    }

    @GetMapping("/{id}")
    public Recipes findRecipe(@PathVariable Long id) {
        return recipesService.findRecipe(id);
    }

    @PostMapping
    public void insertRecipe(@RequestBody Recipes recipe) {
        recipesService.insertRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        Recipes recipe = findRecipe(id);
        recipesService.deleteRecipe(recipe);
    }

}
