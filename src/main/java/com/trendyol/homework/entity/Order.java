package com.trendyol.homework.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Order entity representing a customer's order.
 * Contains foreign keys to customer and product.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many orders can belong to one customer
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Many orders can include one product
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Order date in the format "yyyy-MM-dd"
    private LocalDate orderDate;

    // Quantity of the product ordered
    private Integer quantity;

    public Order() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getOrderDate() {
        return orderDate;

    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
