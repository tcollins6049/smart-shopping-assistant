package com.example.demo.services;

import com.example.demo.models.Shopping_List_Items;
import com.example.demo.repositories.Shopping_List_ItemsRepository;
import com.example.demo.models.Recipe_Items;
import com.example.demo.repositories.Recipe_ItemsRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing operations related to the Shopping_List_Items table
 * Acts as intermediary between the controller and repository.
 */
@Service
public class Shopping_List_itemsService {
    
    @Autowired
    private Shopping_List_ItemsRepository shopping_list_itemsRepository;

    @Autowired
    private Recipe_ItemsRepository recipe_ItemsRepository;

    /**
     * Retrieves all shopping list items for a shopping list based on its shopping list id
     * 
     * @param shopping_list_id The ID of the shopping list
     * @return A list of items in the shopping list
     */
    public List<Shopping_List_Items> findAllSListItems(Long shopping_list_id) {
        return shopping_list_itemsRepository.findAllItems(shopping_list_id);
    }

    /**
     * Retrieves a shopping list item by its ID
     * 
     * @param id The item's ID
     * @return The item, or null if not found
     */
    public Shopping_List_Items findItemById(Long id) {
        Optional<Shopping_List_Items> optionalItem = shopping_list_itemsRepository.findById(id);
        return optionalItem.orElse(null);
    }

    /**
     * Inserts a new item into the shopping list.
     * 
     * @param shopping_list_item The item to insert
     */
    public void insertListItem(Shopping_List_Items shopping_list_item) {
        shopping_list_itemsRepository.insert(shopping_list_item);
    }

    /**
     * Deletes an item from the shopping list
     * 
     * @param shopping_list_item The item to delete
     */
    public void deleteListItem(Shopping_List_Items shopping_list_item) {
        shopping_list_itemsRepository.delete(shopping_list_item);
    }

    /**
     * Gets the next available ID to use when inserting a new shopping list item
     * 
     * @return The next ID
     */
    public Long getNextId() {
        return shopping_list_itemsRepository.getNextId();
    }

    /**
     * Adds all products from a recipe to the shopping list.
     * 
     * @param recipe_id The ID of the recipe
     * @param shopping_list_id The ID of the target shopping list
     */
    @Transactional
    public void addRecipeToShoppingList(Long recipe_id, Long shopping_list_id) {
        List<Recipe_Items> recipeItems = recipe_ItemsRepository.findAllRecipeItems(recipe_id);

        for (Recipe_Items item : recipeItems) {
            Long nextId = getNextId();

            Shopping_List_Items listItem = new Shopping_List_Items(
                nextId,
                shopping_list_id,
                item.getProduct_id(),
                item.getQuantity()
            );

            insertListItem(listItem);
        }
    }
}
