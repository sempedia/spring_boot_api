package com.trendyol.homework.repository;

import com.trendyol.homework.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository provides CRUD operations for the Customer entity.
 * It extends JpaRepository, which includes methods like save, findAll, findById, delete, etc.
 */
@Repository // Marks this interface as a Spring-managed repository bean
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // No need to write any methods — inherited from JpaRepository.
    // You can add custom queries here if needed (e.g., findByEmail).
}
