package com.tss.AccountManagementARRAYLIST;

public class Transaction {
    private long transactionId;
    private static long count=0;
    private String type;
    private long sender,receiver;
    private double amount;

    public Transaction(String type,long sender, long receiver, double amount)
    {
        count++;
        this.transactionId=count*10;
        this.type=type;
        this.sender=sender;
        this.receiver=receiver;
        this.amount=amount;
    }

    public String toString(){
        if(receiver==0){
            return transactionId+"\t"+type+"\t"+sender+"\t-\t"+amount;
        } else if (sender==0) {
            return "";
        }
        return transactionId+"\t"+type+"\t"+sender+"\t"+receiver+"\t"+amount;
    }
}
