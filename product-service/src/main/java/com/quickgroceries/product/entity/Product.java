package com.quickgroceries.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Product.
 */
@Entity
@Table(name = "tproduct")
public class Product {

	/** The uidpk. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UIDPK")
	private long uidpk;

	/** The product name. */
	@Column(name = "Product_Name")
	private String productName;

	/** The product description. */
	@Column(name = "Product_Description")
	private String productDescription;

	/** The product short name. */
	@Column(name = "Product_Short_Name")
	private String productShortName;

	/** The list price amt. */
	@Column(name = "List_Price")
	private Double listPriceAmt;

	/** The currency. */
	@Column(name = "Currency")
	private String currency;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
		super();
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param productName        the product name
	 * @param productDescription the product description
	 * @param productShortName   the product short name
	 * @param listPriceAmt       the list price amt
	 * @param currency           the currency
	 */
	public Product(String productName, String productDescription, String productShortName, Double listPriceAmt,
			String currency) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productShortName = productShortName;
		this.listPriceAmt = listPriceAmt;
		this.currency = currency;
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param uidpk              the uidpk
	 * @param productName        the product name
	 * @param productDescription the product description
	 * @param productShortName   the product short name
	 * @param listPriceAmt       the list price amt
	 * @param currency           the currency
	 */
	public Product(long uidpk, String productName, String productDescription, String productShortName,
			Double listPriceAmt, String currency) {
		super();
		this.uidpk = uidpk;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productShortName = productShortName;
		this.listPriceAmt = listPriceAmt;
		this.currency = currency;
	}

	/**
	 * Gets the uidpk.
	 *
	 * @return the uidpk
	 */
	public long getUidpk() {
		return uidpk;
	}

	/**
	 * Sets the uidpk.
	 *
	 * @param uidpk the new uidpk
	 */
	public void setUidpk(long uidpk) {
		this.uidpk = uidpk;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product description.
	 *
	 * @return the product description
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Sets the product description.
	 *
	 * @param productDescription the new product description
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * Gets the product short name.
	 *
	 * @return the product short name
	 */
	public String getProductShortName() {
		return productShortName;
	}

	/**
	 * Sets the product short name.
	 *
	 * @param productShortName the new product short name
	 */
	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	/**
	 * Gets the list price amt.
	 *
	 * @return the list price amt
	 */
	public Double getListPriceAmt() {
		return listPriceAmt;
	}

	/**
	 * Sets the list price amt.
	 *
	 * @param listPriceAmt the new list price amt
	 */
	public void setListPriceAmt(Double listPriceAmt) {
		this.listPriceAmt = listPriceAmt;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
