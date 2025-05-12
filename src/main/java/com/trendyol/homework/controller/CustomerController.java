// Package location: this controller is part of the "controller" layer of your app.
package com.trendyol.homework.controller;

// Importing the Customer model (entity) and the service class

import com.trendyol.homework.entity.Customer;
import com.trendyol.homework.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CustomerController is the entry point for handling HTTP requests related to "Customer" resources.
 * This class defines the RESTful API endpoints and delegates business logic to the CustomerService.
 */
@RestController  // Marks this class as a REST controller (all responses are JSON by default)
@RequestMapping("/api/customers") // All endpoints in this class will start with this path
public class CustomerController {

    // Injecting the CustomerService using Spring's dependency injection
    @Autowired
    private CustomerService customerService;

    /**
     * GET /api/customers
     * Returns a list of all customers from trendyol database.
     */
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * GET /api/customers/{id}
     * Returns a specific customer by their ID.
     *
     * @param id ID of the customer to retrieve
     */
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    /**
     * POST /api/customers
     * Creates a new customer from the JSON body.
     *
     * @param customer the customer data from the request body
     */
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    /**
     * PUT /api/customers/{id}
     * Updates an existing customer.
     *
     * @param id              ID of the customer to update
     * @param customerDetails new customer data to replace the old one
     */
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(id, customerDetails);
    }

    /**
     * DELETE /api/customers/{id}
     * Deletes a customer by ID.
     *
     * @param id ID of the customer to delete
     */
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
