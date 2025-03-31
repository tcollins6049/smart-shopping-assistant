package com.example.demo.repositories;

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
public class UsersRepoTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void testFindAll() {
        List<Users> users = usersRepository.findAll();
        assertNotNull(users);
    }

    @Test
    void testInsertDeleteUser() {
        // Create user and insert
        Users new_user = new Users(getNextId(), "Test Username", "Test Password");
        usersRepository.insert(new_user);

        // Verify the user was inserted
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Users WHERE username = ? AND password_hash = ?",
            Integer.class, new_user.getUsername(), new_user.getPassword());
        assertEquals(1, count.intValue(), "The user was successfully inserted");
    
        // Delete the user
        usersRepository.delete(new_user);
    }

    public Long getNextId() {
        String sql = "SELECT MAX(id) FROM Users";
        Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
        return (maxId != null ? maxId + 1 : 2);
    }
    
}
