package com.tss.AccountManagementARRAYLIST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import static com.tss.utils.GlobalConstants.scanner;
import static com.tss.utils.Validate.*;

public class AccountApp {

    static Random random = new Random();
    static List<Account> accounts=new ArrayList<>();
    static int count=1;

    public static void main(String[] args) {
        while (true){
            displayMenu();
            System.out.print("\n Enter your Choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            while (true) {
                if (choice > 0 && choice < 11) {
                    break;
                } else {
                    System.out.print("Enter valid choice from menu:");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            switch (choice){
                case 1:
                    accounts.add(makeAccount());
                    count++;
                    break;
                case 2:
                    displayAllAccounts();
                    break;
                case 3:
                    searchAccounts();
                    break;
                case 4:
                    depositMoney();
                    break;
                case 5:
                    withdrawMoney();
                    break;
                case 6:
                    deleteAccount();
                    break;
                case 7:
                    transferMoney();
                    break;
                case 8:
                    displayTransactionOfAccount();
                    break;
                case 9:
                    displayAllTransactions();
                    break;
                case 10:
                    System.out.println("EXITING...");
                    return;
            }
        }
    }

    private static void displayMenu(){
        System.out.println("\nMAIN MENU: ");
        System.out.println("1. Create Account");
        System.out.println("2. Display all Accounts");
        System.out.println("3. Search Account and Display Details");
        System.out.println("4. Deposit Money");
        System.out.println("5. Withdraw Money");
        System.out.println("6. Delete Account");
        System.out.println("7. Transfer Money");
        System.out.println("8. Display Transactions");
        System.out.println("9. Display All Transactions");
        System.out.println("10. Exit");
    }

    private static void displayAllTransactions(){
        System.out.println("TRANSACTION ID\tTYPE\tSENDER(Main Acc)\tRECEIVER\t AMOUNT TRANSFERRED");
        for(Account account:accounts){
            for(Transaction transaction:account.getTransactions()){
                System.out.println(transaction);
            }
        }
    }

    private static void displayTransactionOfAccount(){
        Account myAccount=getAccountFromAccountNumber();
        if(myAccount==null){
            System.out.println("NO SUCH ACCOUNT FOUND!");
            return;
        }
        System.out.println("TRANSACTION ID\tTYPE\tSENDER(Main Acc)\tRECEIVER\t AMOUNT TRANSFERRED");
        for(Transaction transaction:myAccount.getTransactions()){
            System.out.println(transaction);
        }
    }

    private static long getUniqueAccountNumber() {
        long newNumber;
        boolean flag;
        do {
            newNumber = random.nextLong(1_000_000_000L, 10_000_000_000L);
            flag = false;

            for (Account account : accounts) {
                if (account.getAccountNumber() == newNumber) {
                    flag = true;
                    break;
                }
            }
        } while (flag);

        return newNumber;
    }

    private static Account makeAccount(){
        Account newAccount;
        System.out.print("Enter Your Name: ");
        String name=validateCharOnlyString();

        System.out.print("Enter Balance: ");
        double balance= validatePositiveDouble();

        long id=count;
        long accountNumber=getUniqueAccountNumber();

        System.out.println("Available Account Types:");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.print("\nChoose from Above: ");
        int choice=validatePositiveInt();
        while(!(choice>0 && choice<3)){
            System.out.print("Enter Correct Value: ");
            choice=validatePositiveInt();
        }
        if(choice==1){
            newAccount=makeNewSavingsAccount(name,accountNumber,id,balance);
            return newAccount;
        }
        newAccount=makeNewCurrentAccount(name,accountNumber,id,balance);
        return newAccount;
    }


    private static CurrentAccount makeNewCurrentAccount(String name,long accountNumber,long id,double balance){
        System.out.print("Enter Minimum Balance: ");
        double minimumBalance=validatePositiveDouble();

        return new CurrentAccount(name,balance,accountNumber,id,minimumBalance);
    }
    private static SavingsAccount makeNewSavingsAccount(String name,long accountNumber,long id,double balance){
        System.out.print("Enter Offer Rate: ");
        double offerRate=validatePositiveDouble();

        return new SavingsAccount(name,balance,accountNumber,offerRate,id);
    }

    private static void displayAllAccounts(){
        for(Account account: accounts){
            System.out.println(account);
        }
    }


    private static void searchAccounts(){
        System.out.print("Enter account Number: ");
        long accountNumber= validatePositiveLong();

        for(Account account: accounts){
            if(account.getAccountNumber()==accountNumber){
                System.out.println(account);
                return;
            }
        }
        System.out.println("ACCOUNT NOT FOUND!");
    }


    private static void deleteAccount(){
        System.out.print("Enter account Number: ");
        long accountNumber= validatePositiveLong();

        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAccountNumber()==accountNumber){
                accounts.remove(i);
                return;
            }
        }
        System.out.println("ACCOUNT NOT FOUND!");
    }


    private static void depositMoney(){
        Account myAccount=getAccountFromAccountNumber();
        if(myAccount==null){
            System.out.println("ACCOUNT NOT FOUND!");
            return;
        }
        System.out.print("Enter Amount: ");
        double amount= validatePositiveDouble();

        myAccount.deposit(amount);
        System.out.println(amount+" Credited... Current Balance= "+myAccount.getBalance());
    }


    public static void transferMoney(){

        System.out.println("SENDER DETAILS:");
        Account sender=getAccountFromAccountNumber();

        if(sender==null){
            System.out.println("No such account found!");
            return;
        }

        System.out.println("RECEIVER DETAILS:");
        Account receiver=getAccountFromAccountNumber();

        if(receiver==null){
            System.out.println("No such Account Found!");
            return;
        }
        if(sender==receiver){
            System.out.println("Same Account Transaction Detected!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount=validatePositiveDouble();

        if(sender.getBalance()<amount){
            System.out.println("INSUFFICIENT BALANCE!");
            return;
        }
        sender.addTransaction(new Transaction("Transfer",sender.getAccountNumber(),receiver.getAccountNumber(),amount));
        receiver.addTransaction(new Transaction("Transfer",sender.getAccountNumber(),receiver.getAccountNumber(),amount));
        try{
            sender.withdraw(amount);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        receiver.deposit(amount);
        System.out.println("TRANSACTION SUCCESSFUL :)");
    }


    private static Account getAccountFromAccountNumber(){
        System.out.println("Enter Account Number: ");
        long accountNumber= validatePositiveLong();

        for(Account account: accounts){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        return null;
    }


    private static void withdrawMoney(){
        Account myAccount=getAccountFromAccountNumber();
        if(myAccount==null){
            System.out.println("ACCOUNT NOT FOUND!");
            return;
        }
        System.out.print("Enter Amount: ");
        double amount=validatePositiveDouble();

        try{
            myAccount.withdraw(amount);
            System.out.println(amount+" Withdrawn from your account... current balance= "+myAccount.getBalance());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
