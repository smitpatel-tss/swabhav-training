package com.tss.AccountManagementARRAYLIST;

import com.tss.customExceptions.MinimumBalanceException;

public class CurrentAccount extends Account {
    double minimumBalance;

    public CurrentAccount(String name, double balance, long accountNumber,long id, double minimumBalance) {
        super(id,accountNumber,name,balance);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public void withdraw(double amount) throws MinimumBalanceException {
        if (getBalance() - amount < minimumBalance) {
            throw new MinimumBalanceException(minimumBalance);
        } else {
            super.withdraw(amount);
        }
    }

    public void deposit(double amount) {
        super.deposit(amount);
    }
}

