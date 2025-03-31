package com.example.demo.models;

import jakarta.persistence.Entity;    // Marks class as JPA entity
import jakarta.persistence.Id;    // Used to specify primary key
import jakarta.persistence.Table; // Anootation to specify table name
import jakarta.persistence.Column;    // Annotations to map fields to corresponding columns

@Entity
@Table(name="Shopping_List")
public class Shopping_List {
    
    @Id
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    // Default Constructor
    public Shopping_List() {}

    // Arg Constructor
    public Shopping_List(Long id, Long user_id) {
        this.id = id;
        this.user_id = user_id;
    }


    // Accessors and Mutators for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // Accessors and Mutators for user_id
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
