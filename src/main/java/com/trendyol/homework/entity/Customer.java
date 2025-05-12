package com.trendyol.homework.entity;

import jakarta.persistence.*;

/**
 * Customer entity represents a table named 'customers' in the database.
 * Fields in this class map to columns in the table.
 */
@Entity // Specifies that this class is a JPA entity (a table)
@Table(name = "customers") // Maps the entity to the 'customers' table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key, auto-incremented

    @Column(nullable = false)
    private String name; // Customer name, required

    @Column(unique = true)
    private String email; // Customer email, must be unique

    // Default constructor is required by JPA
    public Customer() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
