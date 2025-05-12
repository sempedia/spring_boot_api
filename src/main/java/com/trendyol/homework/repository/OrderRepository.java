package com.trendyol.homework.repository;

import com.trendyol.homework.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for accessing Order data.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
