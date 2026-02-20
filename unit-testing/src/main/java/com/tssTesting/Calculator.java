package com.tssTesting;

public class Calculator {
    private double sum(double a,double b){
        return a+b;
    }
    double multiply(double a,double b){
        return sum(a,b)*sum(a,b);
    }
    public double divide(double a,double b){
        if(b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }
}
