package com.example.demo.repositories;

import com.example.demo.models.Products;
import com.example.demo.models.Recipe_Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Optional;
import java.util.List;

@Repository
public class Recipe_ItemsRepository implements RepositoryInterface<Recipe_Items> {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all recipe items for specific recipe_id
    public List<Recipe_Items> findAllRecipeItems(Long recipe_id) {
        String sql = "SELECT * FROM Recipe_Items WHERE recipe_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Recipe_Items.class), recipe_id);
    }

    // Insert item into recipe_items
    @Override
    public void insert(Recipe_Items recipe_item) {
        // Check if item is already in list
        String checkSql = "SELECT COUNT(*) FROM Recipe_Items WHERE recipe_id = ? AND product_id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, recipe_item.getRecipe_id(), recipe_item.getProduct_id());

        if (count > 0) {
            // Item is already in shopping list so increment quantity
            String updateSql = "UPDATE Recipe_Items SET quantity = quantity + 1 WHERE recipe_id = ? AND product_id = ?";
            jdbcTemplate.update(updateSql, recipe_item.getRecipe_id(), recipe_item.getProduct_id());
        } else {
            // Item doesn't exist so add it.
            String sql = "INSERT INTO Recipe_Items (id, recipe_id, product_id, quantity) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, recipe_item.getId(), recipe_item.getRecipe_id(), recipe_item.getProduct_id(), recipe_item.getQuantity());
        }
    }

    // Delete item from recipe_items
    @Override
    public void delete(Recipe_Items recipe_item) {
        String sql = "DELETE FROM Recipe_Items WHERE id = ?";
        jdbcTemplate.update(sql, recipe_item.getId());
    }

    public Optional<Recipe_Items> findById(Long id) {
        String sql = "SELECT * FROM Recipe_Items WHERE id = ?";
        List<Recipe_Items> recipe_item = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Recipe_Items.class), id);
        if (recipe_item.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(recipe_item.get(0));
        }
    }

    public Long getNextId() {
        String sql = "SELECT MAX(id) FROM Recipe_Items";
        Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("MAXID: " + maxId);
        return (maxId != null ? maxId + 1 : 2);
    }
}
