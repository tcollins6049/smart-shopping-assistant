package com.example.demo.repositories;

import com.example.demo.models.Products;
import com.example.demo.models.Shopping_List;
import com.example.demo.models.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Optional;
import java.util.List;

@Repository
public class Shopping_ListRepository implements RepositoryInterface<Shopping_List> {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all Shopping lists
    public List<Shopping_List> findAll() {
        String sql = "SELECT * FROM Shopping_List";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shopping_List.class));
    }

    // Insert list into Shopping_List table
    @Override
    public void insert(Shopping_List shopping_list) {
        String sql = "INSERT INTO Shopping_List (id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, shopping_list.getId(), shopping_list.getUser_id());
    }

    // Delete list from shopping_list table
    @Override
    public void delete(Shopping_List shopping_list) {
        String sql = "DELETE FROM Shopping_List WHERE user_id = ?";
        jdbcTemplate.update(sql, shopping_list.getUser_id());
    }

    // Find entry in Products table by user_id
    public Optional<Shopping_List> findByUser_id(Long user_id) {
        String sql = "SELECT * FROM Shopping_List WHERE user_id = ?";
        List<Shopping_List> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shopping_List.class), user_id);
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(list.get(0));
        }
    }

    public Optional<Shopping_List> findById(Long id) {
        String sql = "SELECT * FROM Shopping_List WHERE id = ?";
        List<Shopping_List> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Shopping_List.class), id);
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(list.get(0));
        }
    }
}
