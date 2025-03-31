package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Shopping_ListTest {
    
    private Shopping_List shopping_list;

    @BeforeEach
    public void setUp() {
        shopping_list = new Shopping_List(1L, 3L);
    }

    // Tests for accessors
    @Test
    public void testGetId() {
        assertEquals(1L, shopping_list.getId());
    }

    @Test
    public void testGetUser_id() {
        assertEquals(3L, shopping_list.getUser_id());
    }

    // Tests for mutators
    @Test
    public void testSetId() {
        shopping_list.setId(2L);
        assertEquals(2L, shopping_list.getId());
    }

    @Test
    public void testSetUser_id() {
        shopping_list.setUser_id(4l);
        assertEquals(4L, shopping_list.getUser_id());
    }
}
