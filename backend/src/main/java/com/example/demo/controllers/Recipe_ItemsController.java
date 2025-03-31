package com.example.demo.controllers;

import com.example.demo.models.Recipe_Items;
import com.example.demo.services.Recipe_ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe_items")
public class Recipe_ItemsController {
    
    @Autowired
    private Recipe_ItemsService recipe_itemsService;

    @GetMapping
    public Long getNextId() {
        return recipe_itemsService.getNextId();
    }

    @GetMapping("/{id}")
    public Recipe_Items findRecipeItem(Long id) {
        return recipe_itemsService.findRecipeItem(id);
    }

    @GetMapping("/recipe/{recipe_id}")
    public List<Recipe_Items> findAllRecipeItems(@PathVariable Long recipe_id) {
        return recipe_itemsService.findAllRecipeItems(recipe_id);
    }

    @PostMapping
    public void insertRecipeItem(@RequestBody Recipe_Items recipe_item) {
        recipe_itemsService.insertRecipeItem(recipe_item);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeItem(@PathVariable Long id) {
        Recipe_Items recipe_item = findRecipeItem(id);
        recipe_itemsService.deleteRecipeItem(recipe_item);
    }
}
