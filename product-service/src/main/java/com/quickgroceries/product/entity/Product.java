package com.quickgroceries.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tproduct")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UIDPK")
	private long uidpk;

	@Column(name = "Product_Name")
	private String productName;

	@Column(name = "Product_Description")
	private String productDescription;

	@Column(name = "Product_Short_Name")
	private String productShortName;

	@Column(name = "List_Price")
	private Double listPriceAmt;

	@Column(name = "Currency")
	private String currency;

	public Product() {
		super();
	}

	public Product(String productName, String productDescription, String productShortName, Double listPriceAmt,
			String currency) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productShortName = productShortName;
		this.listPriceAmt = listPriceAmt;
		this.currency = currency;
	}

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

	public long getUidpk() {
		return uidpk;
	}

	public void setUidpk(long uidpk) {
		this.uidpk = uidpk;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductShortName() {
		return productShortName;
	}

	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	public Double getListPriceAmt() {
		return listPriceAmt;
	}

	public void setListPriceAmt(Double listPriceAmt) {
		this.listPriceAmt = listPriceAmt;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
