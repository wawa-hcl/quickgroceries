package com.quickgroceries.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quickgroceries.cart.entity.Cart;
import com.quickgroceries.cart.entity.State;

/**
 * The Interface CartRepository.
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	/**
	 * Find by customer uid.
	 *
	 * @param customerId the customer id
	 * @return the optional
	 */
	@Query("select c from Cart c where c.customerUid = ?1")
	Optional<Cart> findByCustomerUid(Long customerId);

	/**
	 * Find by state.
	 *
	 * @param stateValue the state value
	 * @return the list
	 */
	List<Cart> findByState(State stateValue);
}
