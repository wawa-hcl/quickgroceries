package com.quickgroceries.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickgroceries.cart.entity.CartItem;

/**
 * The Interface CartItemRepository.
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
