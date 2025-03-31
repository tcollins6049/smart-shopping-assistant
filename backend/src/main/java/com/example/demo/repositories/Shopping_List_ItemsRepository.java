package com.example.demo.repositories;

import com.example.demo.models.Products;
import com.example.demo.models.Shopping_List_Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Optional;
import java.util.List;

@Repository
public class Shopping_List_ItemsRepository implements RepositoryInterface<Shopping_List_Items> {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all items in shopping list for specific list
    public List<Shopping_List_Items> findAllItems(Long shopping_list_id) {
        String sql = "SELECT * FROM Shopping_List_Items WHERE shopping_list_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shopping_List_Items.class), shopping_list_id);
    }

    @Override
    public void insert(Shopping_List_Items shopping_list_item) {
        // Check if item is already in list
        String checkSql = "SELECT COUNT(*) FROM Shopping_List_Items WHERE shopping_list_id = ? AND product_id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, shopping_list_item.getShopping_list_id(), shopping_list_item.getProduct_id());

        if (count > 0) {
            // Item is already in shopping list so increment quantity
            String updateSql = "UPDATE Shopping_List_Items SET quantity = quantity + 1 WHERE shopping_list_id = ? AND product_id = ?";
            jdbcTemplate.update(updateSql, shopping_list_item.getShopping_list_id(), shopping_list_item.getProduct_id());
        } else {
            // Record doesn't exist so insert a new one
            String sql = "INSERT INTO Shopping_List_Items (id, shopping_list_id, product_id, quantity) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, shopping_list_item.getId(), shopping_list_item.getShopping_list_id(), shopping_list_item.getProduct_id(), shopping_list_item.getQuantity());
        }
    }

    @Override
    public void delete(Shopping_List_Items shopping_list_item) {
        String sql = "DELETE FROM Shopping_List_Items WHERE id = ? AND shopping_list_id = ? AND product_id = ?";
        jdbcTemplate.update(sql, shopping_list_item.getId(), shopping_list_item.getShopping_list_id(), shopping_list_item.getProduct_id());
    }

    public Optional<Shopping_List_Items> findById(Long id) {
        String sql = "SELECT * FROM Shopping_List_Items WHERE id = ?";
        List<Shopping_List_Items> list_items = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shopping_List_Items.class), id);
        if (list_items.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(list_items.get(0));
        }
    }

    public Long getNextId() {
        String sql = "SELECT MAX(id) FROM Shopping_List_Items";
        Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("MAXID: " + maxId);
        return (maxId != null ? maxId + 1 : 2);
    }
}
