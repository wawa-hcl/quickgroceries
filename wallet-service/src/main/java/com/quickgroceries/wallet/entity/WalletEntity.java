package com.quickgroceries.wallet.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "twallet")
public class WalletEntity implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long uidpk;
	
	@Column
	private int customerUId;
	
	@Column	
	@NotNull(message = "Please enter some amount")
	@Digits(message = "Enter only numeric value", fraction = 0, integer = 0)
	@Positive(message = "credit amount should be greater than 0")
	private double amount;
	
	@Column
	@NotNull(message = "Please enter currency Type")
	private String currency;
	
	public WalletEntity() {
		
	}

	public WalletEntity(long uidpk, int customerUId, double amount, String currency) {
		super();
		this.uidpk = uidpk;
		this.customerUId = customerUId;
		this.amount = amount;
		this.currency = currency;
	}

	public long getUidpk() {
		return uidpk;
	}

	public void setUidpk(long uidpk) {
		this.uidpk = uidpk;
	}

	public int getCustomerUId() {
		return customerUId;
	}

	public void setCustomerUId(int customerUId) {
		this.customerUId = customerUId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "WalletEntity [uidpk=" + uidpk + ", customerUId=" + customerUId + ", amount=" + amount + ", currency="
				+ currency + "]";
	}
	
	
	
	
	

}
