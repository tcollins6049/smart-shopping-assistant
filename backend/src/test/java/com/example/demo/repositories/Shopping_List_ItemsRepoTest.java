package com.example.demo.repositories;

import com.example.demo.models.Shopping_List;
import com.example.demo.models.Shopping_List_Items;
import com.example.demo.models.Users;
import com.example.demo.models.Products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;


@SpringBootTest(classes = {com.example.demo.SmartShoppingAssistantApplication.class})
public class Shopping_List_ItemsRepoTest {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Shopping_List_ItemsRepository shopping_list_itemsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private Shopping_ListRepository shopping_listRepository;

    @Autowired
    private ProductsRepository productsRepository;


    @Test
    void testInsertDeleteListItem() {
        // TODO
    }
}
