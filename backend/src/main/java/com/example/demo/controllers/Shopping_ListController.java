package com.example.demo.controllers;

import com.example.demo.models.Shopping_List;
import com.example.demo.services.Shopping_ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/shopping-list")
public class Shopping_ListController {
    
    @Autowired
    private Shopping_ListService shopping_listService;

    @GetMapping("/{user_id}")
    public Shopping_List findShoppingList(@PathVariable Long user_id) {
        Shopping_List shopping_list = shopping_listService.findShoppingList(user_id);
        return shopping_list;
    }

    @PostMapping
    public void addShoppingList(@RequestBody Shopping_List shopping_list) {
        shopping_listService.insertShoppingList(shopping_list);
    }

    @DeleteMapping("/{user_id}")
    public void deleteShoppingList(@PathVariable Long user_id) {
        Shopping_List shopping_list = shopping_listService.findShoppingList(user_id);
        if (shopping_list != null) {
            shopping_listService.deleteShoppingList(shopping_list);
        }
    }
}
