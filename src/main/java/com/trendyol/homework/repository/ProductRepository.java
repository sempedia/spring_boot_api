package com.trendyol.homework.repository;

import com.trendyol.homework.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides built-in CRUD operations for the Product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
