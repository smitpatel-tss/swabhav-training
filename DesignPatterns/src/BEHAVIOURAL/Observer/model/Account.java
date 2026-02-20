package BEHAVIOURAL.Observer.model;

import BEHAVIOURAL.Observer.notifiers.INotifier;

import java.util.List;

public class Account {
    private long id;
    private long accNo;
    private String holderName;
    private double balance;
    private List<INotifier> notifiers;
    private static long count=1;

    public Account( String holderName, double balance, List<INotifier> notifiers) {
        this.id = count;
        this.accNo = (count*900)+count;
        this.holderName = holderName;
        this.balance = balance;
        this.notifiers = notifiers;
        count++;
    }

    public long getId() {
        return id;
    }


    public long getAccNo() {
        return accNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<INotifier> getNotifiers() {
        return notifiers;
    }

    public void setNotifiers(List<INotifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void withdraw(double amount){
        this.balance-=amount;
        notifyCustomer(this,"debited",amount);
    }
    public void deposit(double amount){
        this.balance+=amount;
        notifyCustomer(this,"credited",amount);
    }

    private void notifyCustomer(Account account,String change,double amount){
        if(notifiers.isEmpty()){
            return;
        }
        for(INotifier alertSender:notifiers){
            alertSender.sendAlert(account,change,amount);
        }
    }
}
