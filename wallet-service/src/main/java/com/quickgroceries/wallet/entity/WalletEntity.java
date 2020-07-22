package com.quickgroceries.wallet.entity;

import javax.persistence.*;

@Entity
@Table (name = "twallet")
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
private long uidpk;
    @Column
private long customerUid;
    @Column
private double amount;
    @Column
private String currency;

public WalletEntity(){

}

    public WalletEntity(long uidpk, long customerUid, double amount, String currency) {
        this.uidpk = uidpk;
        this.customerUid = customerUid;
        this.amount = amount;
        this.currency = currency;
    }

    public WalletEntity(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long getUidpk() {
        return uidpk;
    }

    public void setUidpk(long uidpk) {
        this.uidpk = uidpk;
    }

    public long getCustomerUid() {
        return customerUid;
    }

    public void setCustomerUid(long customerUid) {
        this.customerUid = customerUid;
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
        return "WalletEntity{" +
                "uidpk=" + uidpk +
                ", customerUID=" + customerUid +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
