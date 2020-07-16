package com.quickgroceries.wallet.entityDto;

import java.util.UUID;

public class WalletEntityDto {

    private int uidpk;
    private UUID  customerUId;
    private double amount;
    private String currency;

    public WalletEntityDto(){

    }

    public WalletEntityDto(int uidpk, UUID customerUId, double amount, String currency) {
        this.uidpk = uidpk;
        this.customerUId = customerUId;
        this.amount = amount;
        this.currency = currency;
    }

    public int getUidpk() {
        return uidpk;
    }

    public void setUidpk(int uidpk) {
        this.uidpk = uidpk;
    }

    public UUID getCustomerUId() {
        return customerUId;
    }

    public void setCustomerUId(UUID customerUId) {
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

    @Override
    public String toString() {
        return "WalletEntityDto{" +
                "uidpk=" + uidpk +
                ", customerUId='" + customerUId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
