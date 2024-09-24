package com.aplicacionbancaria.aplicacion_bancaria.domain;

import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Users;

public class Account {
    private int accountid;
    public int getAccountid() {
        return accountid;
    }
    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }
    private int userid;
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    private int numberaccount;
    public int getNumberaccount() {
        return numberaccount;
    }
    public void setNumberaccount(int numberaccount) {
        this.numberaccount = numberaccount;
    }
    private int balance;
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    private Users user;

    private Transaction transaction;
    public Users getUsers() {
        return user;
    }
    public void setUsers(Users users) {
        this.user = users;
    }
    public Transaction getTransaction() {
        return transaction;
    }
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
