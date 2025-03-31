package com.example.demo.models;

import jakarta.persistence.Entity;    // Marks class as JPA entity
import jakarta.persistence.Id;    // Used to specify primary key
import jakarta.persistence.Table; // Anootation to specify table name
import jakarta.persistence.Column;    // Annotations to map fields to corresponding columns


@Entity
@Table(name="Recipes")
public class Recipes {
    
    @Id
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "Text")
    private String description;

    @Column(name = "user_id")
    private Long user_id;


    // Default Constructor
    public Recipes() {}

    // Arg Constructor
    public Recipes(Long id, String name, String description, Long user_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user_id = user_id;
    }

    // Accessor and Mutator for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Accessor and Mutator for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Accessor and Mutator for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Accessor and Mutator for user_id
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
