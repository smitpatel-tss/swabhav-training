package com.tss.customExceptions;

public class NegativeAmountException extends Exception{
    public String getMessage(){
        return "YOU CAN'T ENTER NEGATIVE AMOUNT!!!";
    }
}
