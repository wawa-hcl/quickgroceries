package com.quickgroceries.wallet.entityDto;

public class CartResponseDto {

    private long uidpk;
    private double amount;
    private String currency;

    public CartResponseDto() {
    }

    public CartResponseDto(long uidpk, double amount, String currency) {
        this.uidpk = uidpk;
        this.amount = amount;
        this.currency = currency;
    }

    public long getUidpk() {
        return uidpk;
    }

    public void setUidpk(long uidpk) {
        this.uidpk = uidpk;
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
        return "CartResponseDto{" +
                "uidpk=" + uidpk +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
