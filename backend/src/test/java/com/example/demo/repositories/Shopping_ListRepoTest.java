package com.example.demo.repositories;

import com.example.demo.models.Shopping_List;
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
public class Shopping_ListRepoTest {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Shopping_ListRepository shopping_listRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void testInsertDeleteList() {
        // Create user with id 1L (Need because of foreign key)
        Users new_user = new Users(0L, "Test Username", "Test Password");
        usersRepository.insert(new_user);

        // Create list and insert
        Shopping_List new_list = new Shopping_List(getNextId(), 0L);
        shopping_listRepository.insert(new_list);

        // Test Insert
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Shopping_List WHERE user_id = ?",
            Integer.class, new_list.getUser_id());
        assertEquals(1, count.intValue(), "The list was successfully inserted");
    
        // Delete the list and user
        shopping_listRepository.delete(new_list);
        usersRepository.delete(new_user);
    }

    public Long getNextId() {
        String sql = "SELECT MAX(id) FROM Shopping_List";
        Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
        return (maxId != null ? maxId + 1 : 2);
    }
}
