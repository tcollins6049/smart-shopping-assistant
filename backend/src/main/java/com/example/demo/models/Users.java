package com.example.demo.models;

import jakarta.persistence.Entity;    // Marks class as JPA entity
import jakarta.persistence.Id;    // Used to specify primary key
import jakarta.persistence.Table; // Anootation to specify table name
import jakarta.persistence.Column;    // Annotations to map fields to corresponding columns

@Entity
@Table(name = "Users")
public class Users {
    
    @Id
    private Long id;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password_hash", length = 255)
    private String password_hash;

    
    // Default constructor
    public Users() {}

    // Arg constructor
    public Users(Long id, String username, String password_hash) {
        this.id = id;
        this.username = username;
        this.password_hash = password_hash;
    }

    public Users(String username, String password_hash) {
        this.username = username;
        this.password_hash = password_hash;
    }


    // Getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // Accessors and Mutators for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    // Accessors and Mutators for password_hash
    public String getPassword() {
        return password_hash;
    }

    public void setPassword(String password_hash) {
        this.password_hash = password_hash;
    }

}
