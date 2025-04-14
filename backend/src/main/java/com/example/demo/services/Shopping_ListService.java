package com.example.demo.services;

import com.example.demo.models.Shopping_List;
import com.example.demo.repositories.Shopping_ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service layer for managing operations related to the Shopping_List table
 * Acts as intermediary between the controller and repository.
 */
@Service
public class Shopping_ListService {
    
    @Autowired
    private Shopping_ListRepository shopping_listRepository;

    /**
     * Retrieves the shopping list for a specific user.
     * 
     * @param user_id The user's ID.
     * @return The shopping_list object, or null if not found.
     */
    public Shopping_List findShoppingList(Long user_id) {
        Optional<Shopping_List> optional_sList = shopping_listRepository.findByUser_id(user_id);
        System.out.println("Service Shopping List: " + optional_sList);
        return optional_sList.orElse(null);
    }

    /**
     * Inserts a new shopping list into the database
     * 
     * @param shopping_list The shopping list to insert.
     */
    public void insertShoppingList(Shopping_List shopping_list) {
        shopping_listRepository.insert(shopping_list);
    }

    /**
     * Deletes an existing shopping list from the database
     * 
     * @param shopping_list The shopping list to delete.
     */
    public void deleteShoppingList(Shopping_List shopping_list) {
        shopping_listRepository.delete(shopping_list);
    }
}
