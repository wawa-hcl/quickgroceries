package com.quickgroceries.customer.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tcustomer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UIDPK")
	private int uidpk;
	
	@Column(name = "FirstName")
	@NotNull
	@Size(min=2,max=12, message="Name should have atleast 2 characters")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "PhoneNumber")
	@Digits(fraction = 0, integer = 11,message="Please enter numeric value")
	@NotNull
	private int phoneNumber;
	
	@NotNull(message = "Please select Veg or NonVeg")
	@Column(name = "CustomerPreference")
	private String customerPreference;
	
	@Email(message = "Please enter valid email")
	@NotNull
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Username")
	@NotNull(message = "Please your username")
	private String userName;
	
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn (name = "uidpk_address")

	private AddressEntity customerAddress;
	
	public AddressEntity getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(AddressEntity customerAddress) {
		this.customerAddress = customerAddress;
	}
	      
    
	public CustomerEntity() {
		
	}
	
	
	public CustomerEntity(int uidpk, String firstName, String lastName, int phoneNumber, String customerPreference,
			String email, String userName, AddressEntity customerAddress) {
		super();
		this.uidpk = uidpk;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.customerPreference = customerPreference;
		this.email = email;
		this.userName = userName;
		this.customerAddress = customerAddress;
	}
	
	public int getUidpk() {
		return uidpk;
	}
	public void setUidpk(int uidpk) {
		this.uidpk = uidpk;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCustomerPreference() {
		return customerPreference;
	}
	public void setCustomerPreference(String customerPreference) {
		this.customerPreference = customerPreference;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "CustomerEntity [uidpk=" + uidpk + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", customerPreference=" + customerPreference + ", email=" + email
				+ ", userName=" + userName + ", customerAddress=" + customerAddress + "]";
	}
	
}
