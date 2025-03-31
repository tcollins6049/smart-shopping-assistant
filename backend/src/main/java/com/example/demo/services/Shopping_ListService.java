package com.example.demo.services;

import com.example.demo.models.Shopping_List;
import com.example.demo.repositories.Shopping_ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Shopping_ListService {
    
    @Autowired
    private Shopping_ListRepository shopping_listRepository;

    // Find users shopping list
    public Shopping_List findShoppingList(Long user_id) {
        Optional<Shopping_List> optional_sList = shopping_listRepository.findByUser_id(user_id);
        System.out.println("Service Shopping List: " + optional_sList);
        return optional_sList.orElse(null);
    }

    // Insert shopping list into table
    public void insertShoppingList(Shopping_List shopping_list) {
        shopping_listRepository.insert(shopping_list);
    }

    // Delete shopping list from table
    public void deleteShoppingList(Shopping_List shopping_list) {
        shopping_listRepository.delete(shopping_list);
    }
}
