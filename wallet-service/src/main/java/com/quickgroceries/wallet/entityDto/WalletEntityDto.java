package com.quickgroceries.wallet.entityDto;



public class WalletEntityDto {

    private long uidpk;
    private long  customerUId;
    private double amount;
    private String currency;

    public WalletEntityDto(){

    }

    public WalletEntityDto(int uidpk, long customerUId, double amount, String currency) {
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

    public long getCustomerUId() {
        return customerUId;
    }

    public void setCustomerUId(long customerUId) {
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
