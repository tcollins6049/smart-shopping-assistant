package com.example.demo.repositories;

import com.example.demo.models.Recipes;
import com.example.demo.models.Users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;


@SpringBootTest(classes = {com.example.demo.SmartShoppingAssistantApplication.class})
public class Recipe_ItemsRepoTest {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Recipe_ItemsRepository recipe_itemsRepository;

    @Test
    void testInsertDeleteRecipeItem() {
        // TODO
    }
}
