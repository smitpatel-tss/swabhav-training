package com.tss.inClassAssignments;

import com.tss.customExceptions.MinimumBalanceException;
import com.tss.customExceptions.NegativeAmountException;

import java.util.Random;

import java.util.Random;

public abstract class Account {
    private long id,accountNumber;
    private String name;
    private double balance;
    private static long count=0;

    public Account(String name, double balance, long accountNumber) {
        count++;
        this.id = count;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
    public Account(){
        this("NA",0,0);
    }

    public long getId() {
        return id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void deposite(double amount)throws NegativeAmountException {
        this.balance+=amount;
    }
    public void withdraw(double amount) throws MinimumBalanceException, NegativeAmountException {
        this.balance-=amount;
    }
}
