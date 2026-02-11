package com.tss.AccountManagementARRAYLIST;

import com.tss.customExceptions.MinimumBalanceException;
import com.tss.customExceptions.NegativeAmountException;

public class SavingsAccount extends Account {
    double offerRate;

    public SavingsAccount(String name,double balance,long accountNumber,double offerRate,long id){
        super(id,accountNumber,name,balance);
        this.offerRate=offerRate;
    }

    public double getOfferRate() {
        return offerRate;
    }

    public void setOfferRate(double offerRate) {
        this.offerRate = offerRate;
    }

    public void deposit(double amount) {
        if (amount>50000) {
            super.deposit((amount+(amount*(offerRate/100))));
            return;
        }
            super.deposit(amount);

    }

    @Override
    public void withdraw(double amount) throws MinimumBalanceException{
        if(amount>getBalance()){
            System.out.println("INSUFFICIENT BALANCE!");
            return;
        }
            super.withdraw(amount);

    }
}

