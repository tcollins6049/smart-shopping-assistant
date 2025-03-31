package com.example.demo.services;

import com.example.demo.models.Shopping_List_Items;
import com.example.demo.repositories.Shopping_List_ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Shopping_List_itemsService {
    
    @Autowired
    private Shopping_List_ItemsRepository shopping_list_itemsRepository;

    // Find all items in shopping list by shopping_list_id
    public List<Shopping_List_Items> findAllSListItems(Long shopping_list_id) {
        return shopping_list_itemsRepository.findAllItems(shopping_list_id);
    }

    // Find item by id
    public Shopping_List_Items findItemById(Long id) {
        Optional<Shopping_List_Items> optionalItem = shopping_list_itemsRepository.findById(id);
        return optionalItem.orElse(null);
    }

    // Insert into shopping_list_items table
    public void insertListItem(Shopping_List_Items shopping_list_item) {
        shopping_list_itemsRepository.insert(shopping_list_item);
    }

    // Delete from shopping_list_items table
    public void deleteListItem(Shopping_List_Items shopping_list_item) {
        shopping_list_itemsRepository.delete(shopping_list_item);
    }

    // Get next id
    public Long getNextId() {
        return shopping_list_itemsRepository.getNextId();
    }
}
