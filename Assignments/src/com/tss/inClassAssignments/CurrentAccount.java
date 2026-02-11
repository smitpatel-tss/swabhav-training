package com.tss.inClassAssignments;

import com.tss.customExceptions.MinimumBalanceException;
import com.tss.customExceptions.NegativeAmountException;

public class CurrentAccount extends Account {
    double minimumBalance;

    public CurrentAccount(String name, double balance, long accountNumber, double minimumBalance) {
        super(name, balance, accountNumber);
        this.minimumBalance = minimumBalance;
    }

    public CurrentAccount() {
        super();
        this.minimumBalance = 0;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public void withdraw(double amount) throws MinimumBalanceException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        } else if (getBalance() - amount < minimumBalance) {
            throw new MinimumBalanceException(minimumBalance);
        } else {
            super.withdraw(amount);
        }
    }

    public void deposite(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        } else {
            super.deposite(amount);
        }
    }
}
