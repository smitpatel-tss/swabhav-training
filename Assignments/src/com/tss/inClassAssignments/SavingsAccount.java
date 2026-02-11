package com.tss.inClassAssignments;

import com.tss.customExceptions.MinimumBalanceException;
import com.tss.customExceptions.NegativeAmountException;

public class SavingsAccount extends Account{
    double offerRate;

    public SavingsAccount(String name,double balance,long accountNumber,double offerRate){
        super(name,balance,accountNumber);
        this.offerRate=offerRate;
    }
    public SavingsAccount(){
        super();
        this.offerRate=0;
    }

    public double getOfferRate() {
        return offerRate;
    }

    public void setOfferRate(double offerRate) {
        this.offerRate = offerRate;
    }

    public void deposite(double amount) throws NegativeAmountException {
        if(amount<0){
            throw new NegativeAmountException();
        } else if (amount>50000) {
            super.deposite((amount+(amount*(offerRate/100))));
        }else{
            super.deposite(amount);
        }
    }

    @Override
    public void withdraw(double amount) throws MinimumBalanceException, NegativeAmountException {
        if(amount<0){
            throw new NegativeAmountException();
        }
        else if(amount>getBalance()){
            System.out.println("Insufficient Balance!");
        }else{
            super.withdraw(amount);
        }
    }
}
