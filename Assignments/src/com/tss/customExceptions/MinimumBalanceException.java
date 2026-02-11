package com.tss.customExceptions;

public class MinimumBalanceException extends Exception{
    private double minimumBalance;
    public MinimumBalanceException(double minimumBalance){
        this.minimumBalance=minimumBalance;
    }

    @Override
    public String getMessage() {
        return "You must have to maintain the minimum balance of "+minimumBalance+" Rs.";
    }
}
