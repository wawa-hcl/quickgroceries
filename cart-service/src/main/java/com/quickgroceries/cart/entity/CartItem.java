package com.quickgroceries.cart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class CartItem.
 */
@Entity
@Table(name = "tcartitems")
public class CartItem {

	/** The uidpk. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UIDPK")
	private Long uidpk;

	/** The product uid. */
	@Column(name = "ProductUid")
	private Long productUid;

	/** The quantity. */
	@Column(name = "Quantity")
	private Integer quantity;

	/** The cart. */
	@ManyToOne
	@JoinColumn(name = "cartUidpk", nullable = false)
	private Cart cart;

	/**
	 * Instantiates a new cart item.
	 */
	public CartItem() {
		super();
	}

	/**
	 * Instantiates a new cart item.
	 *
	 * @param uidpk      the uidpk
	 * @param productUid the product uid
	 * @param quantity   the quantity
	 * @param cart       the cart
	 */
	public CartItem(Long uidpk, Long productUid, Integer quantity, Cart cart) {
		super();
		this.uidpk = uidpk;
		this.productUid = productUid;
		this.quantity = quantity;
		this.cart = cart;
	}

	/**
	 * Gets the uidpk.
	 *
	 * @return the uidpk
	 */
	public Long getUidpk() {
		return uidpk;
	}

	/**
	 * Sets the uidpk.
	 *
	 * @param uidpk the new uidpk
	 */
	public void setUidpk(Long uidpk) {
		this.uidpk = uidpk;
	}

	/**
	 * Gets the product uid.
	 *
	 * @return the product uid
	 */
	public Long getProductUid() {
		return productUid;
	}

	/**
	 * Sets the product uid.
	 *
	 * @param productUid the new product uid
	 */
	public void setProductUid(Long productUid) {
		this.productUid = productUid;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the cart.
	 *
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * Sets the cart.
	 *
	 * @param cart the new cart
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
