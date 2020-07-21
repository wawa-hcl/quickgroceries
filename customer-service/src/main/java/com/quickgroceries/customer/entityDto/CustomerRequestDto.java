package com.quickgroceries.customer.entityDto;

import com.quickgroceries.customer.entity.AddressEntity;

public class CustomerRequestDto {

    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String customerPreference;
    private String email;
    private String userName;
    private AddressEntity customerAddress;

    public CustomerRequestDto() {
    }

    public CustomerRequestDto(String firstName, String lastName, int phoneNumber, String customerPreference, String email, String userName, AddressEntity customerAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.customerPreference = customerPreference;
        this.email = email;
        this.userName = userName;
        this.customerAddress = customerAddress;
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

    public AddressEntity getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(AddressEntity customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "CustomerRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", customerPreference='" + customerPreference + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", customerAddress=" + customerAddress +
                '}';
    }
}
