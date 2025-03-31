package com.example.demo.models;

import jakarta.persistence.Entity;    // Marks class as JPA entity
import jakarta.persistence.Id;    // Used to specify primary key
import jakarta.persistence.Table; // Anootation to specify table name
import jakarta.persistence.Column;    // Annotations to map fields to corresponding columns


@Entity
@Table(name="Recipe_Items")
public class Recipe_Items {
    
    @Id
    private Long id;

    @Column(name = "recipe_id")
    private Long recipe_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "quantity")
    private int quantity;


    // Default Constructor
    public Recipe_Items() {}

    // Arg Constructor
    public Recipe_Items(Long id, Long recipe_id, Long product_id, int quantity) {
        this.id = id;
        this.recipe_id = recipe_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    // Accessor and Mutator for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Accessor and Mutator for recipe_id
    public Long getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Long recipe_id) {
        this.recipe_id = recipe_id;
    }

    // Accessor and Mutator for product_id
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    // Accessor and Mutator for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
