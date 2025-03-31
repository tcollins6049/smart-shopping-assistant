package com.example.demo.models;

import jakarta.persistence.Entity;    // Marks class as JPA entity
import jakarta.persistence.Id;    // Used to specify primary key
import jakarta.persistence.Table; // Anootation to specify table name
import jakarta.persistence.Column;    // Annotations to map fields to corresponding columns


@Entity
@Table(name="Shopping_List_Items")
public class Shopping_List_Items {
    
    @Id
    private Long id;

    @Column(name = "shopping_list_id")
    private Long shopping_list_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "quantity")
    private int quantity;


    // Default constructor
    public Shopping_List_Items() {}

    // Arg Constructor
    public Shopping_List_Items(Long id, Long shopping_list_id, Long product_id, int quantity) {
        this.id = id;
        this.shopping_list_id = shopping_list_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }


    // Accessors and Mutators for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Accessors and Mutators for shopping_list_id
    public Long getShopping_list_id() {
        return shopping_list_id;
    }

    public void setShopping_list_id(Long shopping_list_id) {
        this.shopping_list_id = shopping_list_id;
    }

    // Accessors and Mutators for product_id
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    // Accessors and Mutators for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
