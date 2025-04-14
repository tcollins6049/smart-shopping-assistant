package com.example.demo.services;

import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing operations related to the Users table
 * Acts as intermediary between the controller and repository.
 */
@Service
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepository;

    /**
     * Retrieves all users from the database
     * 
     * @return A list of all users.
     */
    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    /**
     * Inserts a new user into the database
     * 
     * @param user The user to insert
     */
    public void insertUser(Users user) {
        usersRepository.insert(user);
    }

    /**
     * Deletes a user from the database
     * 
     * @param user The user to delete
     */
    public void deleteUser(Users user) {
        usersRepository.delete(user);
    }

    /**
     * Finds a user by their unique ID.
     * 
     * @param id The user's ID
     * @return The user if found, otherwise null
     */
    public Users findUserById(Long id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
