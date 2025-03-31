package com.example.demo.controllers;

import com.example.demo.models.Shopping_List_Items;
import com.example.demo.services.Shopping_List_itemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping_list_items")
public class Shopping_List_ItemsController {
    
    @Autowired
    private Shopping_List_itemsService shopping_list_itemsService;

    @GetMapping
    public Long getNextId() {
        return shopping_list_itemsService.getNextId();
    }

    @GetMapping("/{shopping_list_id}")
    public List<Shopping_List_Items> findAllSListItems(@PathVariable Long shopping_list_id) {
        return shopping_list_itemsService.findAllSListItems(shopping_list_id);
    }

    @PostMapping
    public void addShoppingListItem(@RequestBody Shopping_List_Items shopping_list_item) {
        shopping_list_itemsService.insertListItem(shopping_list_item);
    }

    @DeleteMapping("/{id}")
    public void deleteShoppingListItem(@PathVariable Long id) {
        Shopping_List_Items shopping_list_item = shopping_list_itemsService.findItemById(id);
        if (shopping_list_item != null) {
            shopping_list_itemsService.deleteListItem(shopping_list_item);
        }
    }
}
