package com.example.demo.repositories;

import com.example.demo.models.Products;
import com.example.demo.models.Recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Optional;
import java.util.List;

@Repository
public class RecipesRepository implements RepositoryInterface<Recipes> {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all recipes for specific user_id
    public List<Recipes> findAllRecipes(Long user_id) {
        String sql = "SELECT * FROM Recipes WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Recipes.class), user_id);
    }

    // Insert recipe into Recipe table
    @Override
    public void insert(Recipes recipe) {
        String sql = "INSERT INTO Recipes (id, name, description, user_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getUser_id());
    }

    // Delete recipe from recipe table
    @Override
    public void delete(Recipes recipe) {
        String sql = "DELETE FROM Recipes WHERE name = ? AND user_id = ?";
        jdbcTemplate.update(sql, recipe.getName(), recipe.getUser_id());
    }

    public Optional<Recipes> findById(Long id) {
        String sql = "SELECT * FROM Recipes WHERE id = ?";
        List<Recipes> recipe = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Recipes.class), id);
        if (recipe.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(recipe.get(0));
        }
    }

    public Long getNextId() {
        String sql = "SELECT MAX(id) FROM Recipes";
        Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("MAXID: " + maxId);
        return (maxId != null ? maxId + 1 : 2);
    }
}
