package com.example.demo.repositories;

import com.example.demo.models.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Optional;
import java.util.List;

@Repository
public class UsersRepository implements RepositoryInterface<Users> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all users in the Users table
    public List<Users> findAll() {
        String sql = "SELECT * FROM Users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class));
    }

    // Insert user into Users table
    @Override
    public void insert(Users user) {
        String sql = "INSERT INTO Users (id, username, password_hash) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword());
    }

    // Delete user from Users table
    @Override
    public void delete(Users user) {
        String sql = "DELETE FROM Users WHERE username = ? AND password_hash = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    // Find entry in Products table by username
    public Optional<Users> findByName(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        List<Users> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class), username);
        if (users.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(users.get(0));
        }
    }

    // Find entry in Products table by id
    public Optional<Users> findById(Long id) {
        String sql = "SELECT * FROM Users WHERE id = ?";
        List<Users> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class), id);
        if (users.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(users.get(0));
        }
    }
}
