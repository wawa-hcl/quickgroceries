package com.quickgroceries.order.entity;

public class Customer {
	private long uidpk;
	public long getUidpk() {
		return uidpk;
	}
	public void setUidpk(long uidpk) {
		this.uidpk = uidpk;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCustomerpreference() {
		return customerpreference;
	}
	public void setCustomerpreference(String customerpreference) {
		this.customerpreference = customerpreference;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String firstname;
	private String lastname;
	private String customerpreference;
	private String email;
	private String username;
}
