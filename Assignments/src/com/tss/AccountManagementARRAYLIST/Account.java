package com.tss.AccountManagementARRAYLIST;

import com.tss.customExceptions.MinimumBalanceException;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private long id,accountNumber;
    private String name;
    private double balance;
    private List<Transaction> transactions;

    public Account(long id, long accountNumber, String name, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.transactions=new ArrayList<>();
    }

    public void addTransaction(Transaction newTransaction){
        transactions.add(newTransaction);
    }

    public long getAccountNumber() {
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public List<Transaction> getTransactions(){
        return transactions;
    }

    @Override
    public String toString() {
        return "\nId: "+id+"\nAccount Number: "+accountNumber+"\nName: "+name+"\nBalance: "+balance;
    }

    public void deposit(double amount){
        this.balance+=amount;
        transactions.add(new Transaction("Deposit",this.accountNumber,0,amount));
    }
    public void withdraw(double amount) throws MinimumBalanceException {
        this.balance-=amount;
        transactions.add(new Transaction("Withdraw",this.accountNumber,0,amount));
    }
}
