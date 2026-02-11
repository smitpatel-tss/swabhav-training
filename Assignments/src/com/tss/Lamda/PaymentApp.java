package com.tss.Lamda;

import java.util.Scanner;

public class PaymentApp {
    public static void main(String[] args) {

        Payment creditCardLogic=(amount)->(amount <= 100000);

        Payment upiLogic=(amount)->(amount<=50000);

        Payment netBankingLogic=(amount)->true;

//        processPayment(creditCardLogic,120000);
//        processPayment(upiLogic,2500);
//        processPayment(netBankingLogic,75000);

        Scanner scanner=new Scanner(System.in);
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");
        System.out.print("Choose Payment Method:");
        int choice=scanner.nextInt();


        while (choice < 1 || choice > 3) {
            System.out.print("Enter Valid Option:");
            choice = scanner.nextInt();
        }
        System.out.print("Enter Amount: ");
        double amount=scanner.nextDouble();
        while (amount<0){
            System.out.print("Enter Valid Amount: ");
            amount=scanner.nextDouble();
        }
        switch (choice){
            case 1:
                System.out.println("Processing Credit Card Payment of "+amount+" Rs.");
                processPayment(creditCardLogic,amount);
                break;
            case 2:
                System.out.println("Processing UPI Payment of "+amount+" Rs.");
                processPayment(upiLogic,amount);
                break;
            case 3:
                System.out.println("Processing Net Banking Payment of "+amount+" Rs.");
                processPayment(netBankingLogic,amount);
                break;
        }



    }
    static void processPayment(Payment paymentObj,double amount){
        if(paymentObj.pay(amount)){
            System.out.println("Payment Successful...");
            return;
        }
        System.out.println("Payment Failed!");

    }
}
