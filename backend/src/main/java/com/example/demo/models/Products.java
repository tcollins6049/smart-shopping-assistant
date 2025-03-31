package com.example.demo.models;

import jakarta.persistence.Entity;    // Marks class as JPA entity
import jakarta.persistence.Id;    // Used to specify primary key
import jakarta.persistence.Table; // Anootation to specify table name
import jakarta.persistence.Column;    // Annotations to map fields to corresponding columns


@Entity
@Table(name="Products")
public class Products {
    
    @Id
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "Text")
    private String description;


    // Default constructor
    public Products() {}

    // Arg constructor
    public Products(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // Getters and Setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Getters and Setters for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
