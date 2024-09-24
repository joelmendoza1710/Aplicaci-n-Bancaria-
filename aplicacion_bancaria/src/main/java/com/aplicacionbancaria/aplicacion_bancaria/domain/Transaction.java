package com.aplicacionbancaria.aplicacion_bancaria.domain;

import java.time.LocalDateTime;

public class Transaction {
    private int transactionid;
    private int accountoriginid;
    private int accountdestinationid;
    private LocalDateTime date;
    private int amount;
    private String description;
    private Account account;
    public int getTransactionid() {
        return transactionid;
    }
    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }
    public int getAccountoriginid() {
        return accountoriginid;
    }
    public void setAccountoriginid(int accountoriginid) {
        this.accountoriginid = accountoriginid;
    }
    public int getAccountdestinationid() {
        return accountdestinationid;
    }
    public void setAccountdestinationid(int accountdestinationid) {
        this.accountdestinationid = accountdestinationid;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }


}
