package com.quickgroceries.cart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tcartitems")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UIDPK")
	private Long uidpk;

	@Column(name = "ProductUid")
	private Long productUid;

	@Column(name = "Quantity")
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name="cartUidpk", nullable=false)
	private Cart cart;

	public CartItem() {
		super();
	}

	public CartItem(Long uidpk, Long productUid, Integer quantity, Cart cart) {
		super();
		this.uidpk = uidpk;
		this.productUid = productUid;
		this.quantity = quantity;
		this.cart = cart;
	}

	public Long getUidpk() {
		return uidpk;
	}

	public void setUidpk(Long uidpk) {
		this.uidpk = uidpk;
	}

	public Long getProductUid() {
		return productUid;
	}

	public void setProductUid(Long productUid) {
		this.productUid = productUid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
