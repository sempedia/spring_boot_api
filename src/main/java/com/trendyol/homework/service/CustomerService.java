package com.trendyol.homework.service;

// Import the repository and entity

import com.trendyol.homework.entity.Customer;
import com.trendyol.homework.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CustomerService is the business logic layer for handling operations related to Customer entities.
 * It acts as a bridge between the CustomerController (presentation layer) and CustomerRepository (data access layer).
 */
@Service // Marks this class as a Spring service component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Retrieves all customers from the database.
     *
     * @return list of all customers
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the customer ID
     * @return the customer with the given ID
     * @throws RuntimeException if no customer is found
     */
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    /**
     * Creates a new customer in the database.
     *
     * @param customer the customer to create
     * @return the saved customer
     */
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Updates an existing customer.
     *
     * @param id              the ID of the customer to update
     * @param customerDetails the new customer data
     * @return the updated customer
     */
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = getCustomerById(id); // reuses method with validation
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        return customerRepository.save(customer);
    }

    /**
     * Deletes a customer by ID.
     *
     * @param id the ID of the customer to delete
     */
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
