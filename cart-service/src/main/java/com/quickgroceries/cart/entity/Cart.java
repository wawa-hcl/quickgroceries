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

@Entity
@Table(name = "tcart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UIDPK")
	private Long cartUidpk;

	@Column(name = "CustomerUid")
	private Long customerUid;

	@Enumerated(EnumType.STRING)
	@Column(name = "State")
	private State state;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItem> cartItem;

	public Cart() {
		super();
	}

	public Cart(Long customerUid, State state, List<CartItem> cartItem) {
		super();
		this.customerUid = customerUid;
		this.state = state;
		this.cartItem = cartItem;
	}

	public Cart(Long customerUid, State state) {
		super();
		this.customerUid = customerUid;
		this.state = state;
	}

	public Long getCartUidpk() {
		return cartUidpk;
	}

	public void setCartUidpk(Long cartUidpk) {
		this.cartUidpk = cartUidpk;
	}

	public Long getCustomerUid() {
		return customerUid;
	}

	public void setCustomerUid(Long customerUid) {
		this.customerUid = customerUid;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

}
