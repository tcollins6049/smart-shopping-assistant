package com.example.demo.services;

import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepository;

    // Method to get all Users
    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    // Insert user into Users table
    public void insertUser(Users user) {
        usersRepository.insert(user);
    }

    // Delete user from Users table
    public void deleteUser(Users user) {
        usersRepository.delete(user);
    }

    public Users findUserById(Long id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
