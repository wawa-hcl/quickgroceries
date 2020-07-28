package com.quickgroceries.cart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Cart.
 */
@Entity
@Table(name = "tcart")
public class Cart {

	/** The cart uidpk. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UIDPK")
	private Long cartUidpk;

	/** The customer uid. */
	@Column(name = "CustomerUid")
	private Long customerUid;

	/** The state. */
	@Enumerated(EnumType.STRING)
	@Column(name = "State")
	private State state;

	/** The cart item. */
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItem> cartItem;

	/**
	 * Instantiates a new cart.
	 */
	public Cart() {
		super();
	}

	/**
	 * Instantiates a new cart.
	 *
	 * @param customerUid the customer uid
	 * @param state       the state
	 * @param cartItem    the cart item
	 */
	public Cart(Long customerUid, State state, List<CartItem> cartItem) {
		super();
		this.customerUid = customerUid;
		this.state = state;
		this.cartItem = cartItem;
	}

	/**
	 * Instantiates a new cart.
	 *
	 * @param customerUid the customer uid
	 * @param state       the state
	 */
	public Cart(Long customerUid, State state) {
		super();
		this.customerUid = customerUid;
		this.state = state;
	}

	/**
	 * Gets the cart uidpk.
	 *
	 * @return the cart uidpk
	 */
	public Long getCartUidpk() {
		return cartUidpk;
	}

	/**
	 * Sets the cart uidpk.
	 *
	 * @param cartUidpk the new cart uidpk
	 */
	public void setCartUidpk(Long cartUidpk) {
		this.cartUidpk = cartUidpk;
	}

	/**
	 * Gets the customer uid.
	 *
	 * @return the customer uid
	 */
	public Long getCustomerUid() {
		return customerUid;
	}

	/**
	 * Sets the customer uid.
	 *
	 * @param customerUid the new customer uid
	 */
	public void setCustomerUid(Long customerUid) {
		this.customerUid = customerUid;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Gets the cart item.
	 *
	 * @return the cart item
	 */
	public List<CartItem> getCartItem() {
		return cartItem;
	}

	/**
	 * Sets the cart item.
	 *
	 * @param cartItem the new cart item
	 */
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

}
