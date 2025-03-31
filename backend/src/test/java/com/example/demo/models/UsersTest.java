package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersTest {
    
    private Users users;

    @BeforeEach
    public void setUp() {
        users = new Users(1L, "Test username", "Test password");
    }

    // Tests for accessors
    @Test
    public void testGetId() {
        assertEquals(1L, users.getId());
    }

    @Test
    public void testGetUsername() {
        assertEquals("Test username", users.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("Test password", users.getPassword());
    }

    // Tests for mutators
    @Test
    public void testSetId() {
        users.setId(2L);
        assertEquals(2L, users.getId());
    }

    @Test
    public void testSetUsername() {
        users.setUsername("Changed username");
        assertEquals("Changed username", users.getUsername());
    }

    @Test
    public void testSetPassword() {
        users.setPassword("Changed password");
        assertEquals("Changed password", users.getPassword());
    }
}
