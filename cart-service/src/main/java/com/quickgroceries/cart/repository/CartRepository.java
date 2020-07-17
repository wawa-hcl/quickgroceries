package com.quickgroceries.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickgroceries.cart.entity.Cart;
import com.quickgroceries.cart.entity.State;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Optional<Cart> findByCustomerUid(Long customerId);

	List<Cart> findByState(State stateValue);
}
