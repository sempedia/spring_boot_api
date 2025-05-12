package com.trendyol.homework.service;

import com.trendyol.homework.entity.Order;
import com.trendyol.homework.exception.CustomerNotFoundException;
import com.trendyol.homework.exception.InvalidDateFormatException;
import com.trendyol.homework.exception.ProductNotFoundException;
import com.trendyol.homework.repository.CustomerRepository;
import com.trendyol.homework.repository.OrderRepository;
import com.trendyol.homework.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Service layer that contains business logic for Order operations.
 */
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;  // Inject CustomerRepository

    @Autowired
    private ProductRepository productRepository;  // Inject ProductRepository

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        // Check for null orderDate and validate the format
        if (order.getOrderDate() == null) {
            throw new InvalidDateFormatException("Invalid order date format.");
        }

        // Validate that the customer exists
        if (order.getCustomer() == null || order.getCustomer().getId() == null ||
                !customerRepository.existsById(order.getCustomer().getId())) {
            throw new CustomerNotFoundException("Customer not found.");
        }

        // Validate that the product exists
        if (order.getProduct() == null || order.getProduct().getId() == null ||
                !productRepository.existsById(order.getProduct().getId())) {
            throw new ProductNotFoundException("Product not found.");
        }

        // Validate that quantity is not null or invalid
        if (order.getQuantity() == null || order.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }

        // Log the creation of the order
        logger.info("Creating order for customer ID: {}, product ID: {}, quantity: {}",
                order.getCustomer().getId(), order.getProduct().getId(), order.getQuantity());

        // Save and return the order
        return orderRepository.save(order);
    }


    public Order updateOrder(Long id, Order orderDetails) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setCustomer(orderDetails.getCustomer());
            order.setProduct(orderDetails.getProduct());
            order.setQuantity(orderDetails.getQuantity());
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // Helper method to check if the date is in the correct format
    private boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
