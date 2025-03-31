package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Shopping_List_ItemsTest {

    private Shopping_List_Items shopping_list_items;

    @BeforeEach
    public void setUp() {
        shopping_list_items = new Shopping_List_Items(1L, 3L, 5L, 10);
    }

    // Accessor Tests
    @Test
    public void testGetId() {
        assertEquals(1L, shopping_list_items.getId());
    }

    @Test
    public void testGetShopping_list_id() {
        assertEquals(3L, shopping_list_items.getShopping_list_id());
    }

    @Test
    public void testGetProduct_id() {
        assertEquals(5L, shopping_list_items.getProduct_id());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(10, shopping_list_items.getQuantity());
    }

    // Mutator Tests
    @Test
    public void testSetId() {
        shopping_list_items.setId(2L);
        assertEquals(2L, shopping_list_items.getId());
     }

     @Test
     public void testSetShopping_list_id() {
        shopping_list_items.setShopping_list_id(4L);
        assertEquals(4L, shopping_list_items.getShopping_list_id());
     }

     @Test
     public void testSetProduct_id() {
        shopping_list_items.setProduct_id(6L);
        assertEquals(6L, shopping_list_items.getProduct_id());
     }

     @Test
     public void testSetQuantity() {
        shopping_list_items.setQuantity(12);
        assertEquals(12, shopping_list_items.getQuantity());
     }
}
