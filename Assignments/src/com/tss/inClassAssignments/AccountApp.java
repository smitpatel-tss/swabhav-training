package com.tss.inClassAssignments;

import com.tss.customExceptions.MinimumBalanceException;
import com.tss.customExceptions.NegativeAmountException;

import java.util.Random;
import java.util.Scanner;

public class AccountApp {

    static Scanner scanner = new Scanner(System.in);
    static int MAX_NUM_OF_ACCOUNTS = 100;
    static Account[] accounts = new Account[MAX_NUM_OF_ACCOUNTS];
    static int count = 0;
    static Random random = new Random();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Balance");
            System.out.println("5. Money Transfer");
            System.out.println("6. Exit");
            System.out.print("\n Enter your Choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            while (true) {
                if (choice > 0 && choice < 7) {
                    break;
                } else {
                    System.out.print("Enter valid choice from menu:");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("CREATING AN ACCOUNT");
                    System.out.println("1. Savings");
                    System.out.println("2. Current");

                    int accountType;

                    while(true){
                        System.out.print("Choose which account you want to create:");
                        if(!scanner.hasNextInt()){
                            System.out.println("Enter numeric values Only!");
                            scanner.next();
                            continue;
                        }

                        accountType= scanner.nextInt();

                        if(accountType>0 && accountType<3){
                            break;
                        }
                        System.out.println("Choose valid option from above!");
                    }
                    if(accountType==1){
                        accounts[count]=makeSavingsAccount();
                        count++;
                    }else{
                        accounts[count]=makeCurrentAccount();
                        count++;
                    }
                    break;

                case 2:
                    if(count==0){
                        System.out.println("Make an Account first!");
                        break;
                    }
                    long accountNumForDeposit;

                    while(true){
                        System.out.print("Enter account number for Deposit: ");
                        if(!scanner.hasNextLong()){
                            System.out.println("Enter numeric value only!");
                            scanner.next();
                            continue;
                        }

                        accountNumForDeposit=scanner.nextLong();

                        if(accountNumForDeposit>=1000000000L && accountNumForDeposit<=9999999999L){
                            break;
                        }
                        System.out.println("Enter valid 10 digit account number!");
                    }
                    Account targetAccountForDeposit=getAccountByNum(accountNumForDeposit);
                    if(targetAccountForDeposit==null){
                        System.out.println("Entered account is not available in database!");
                        break;
                    }

                    double amountToDeposit;

                    while(true){
                        System.out.println("Enter value for Deposit:");

                        if(!scanner.hasNextDouble()){
                            System.out.println("Enter numeric values only!");
                            scanner.next();
                        }else {
                            amountToDeposit=scanner.nextDouble();
                            break;
                        }

                    }

                    try {
                        targetAccountForDeposit.deposite(amountToDeposit);
                    }catch (NegativeAmountException e){
                        System.out.println(e.getMessage());
                    }


                    System.out.println("Current Total Amount in account "+accountNumForDeposit+" is: "+targetAccountForDeposit.getBalance());

                    break;

                case 3:
                    if(count==0){
                        System.out.println("Make an Account first!");
                        break;
                    }
                    long accountNumForWithdraw;

                    while(true){
                        System.out.print("Enter account number for Withdraw: ");
                        if(!scanner.hasNextLong()){
                            System.out.println("Enter numeric value only!");
                            scanner.next();
                            continue;
                        }

                        accountNumForWithdraw=scanner.nextLong();

                        if(accountNumForWithdraw>=1000000000L && accountNumForWithdraw<=9999999999L){
                            break;
                        }
                        System.out.println("Enter valid 10 digit account number!");
                    }
                    Account targetAccountForWithdraw=getAccountByNum(accountNumForWithdraw);

                    if(targetAccountForWithdraw==null){
                        System.out.println("Entered account is not available in database!");
                        break;
                    }

                    double amountToWithdraw;

                    while(true){
                        System.out.println("Enter value for Withdraw:");

                        if(!scanner.hasNextDouble()){
                            System.out.println("Enter numeric values only!");
                            scanner.next();
                            continue;
                        }
                        amountToWithdraw=scanner.nextDouble();

                        if(amountToWithdraw<targetAccountForWithdraw.getBalance()){
                            break;
                        }

                        System.out.println("Enter valid amount!");
                    }

                    try{
                        targetAccountForWithdraw.withdraw(amountToWithdraw);
                    }
                    catch (MinimumBalanceException e){
                        System.out.println(e.getMessage());
                    }catch (NegativeAmountException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    if(count==0){
                        System.out.println("Make an Account first!");
                        break;
                    }

                    long accountNumToShowBalance;

                    while(true){
                        System.out.print("Enter account number to see the Balance: ");
                        if(!scanner.hasNextLong()){
                            System.out.println("Enter numeric value only!");
                            scanner.next();
                            continue;
                        }

                        accountNumToShowBalance=scanner.nextLong();

                        if(accountNumToShowBalance>=1000000000L && accountNumToShowBalance<=9999999999L){
                            break;
                        }
                        System.out.println("Enter valid 10 digit account number!");
                    }
                    Account targetAccountForBalance=getAccountByNum(accountNumToShowBalance);

                    if(targetAccountForBalance==null){
                        System.out.println("Entered account is not available in database!");
                        break;
                    }

                    System.out.println("Balance: "+targetAccountForBalance.getBalance());
                    break;
                case 5:
                    if(count==0){
                        System.out.println("Make an Account first!");
                        break;
                    }
                    if(count<2){
                        System.out.println("You need at least two accounts!");
                        break;
                    }
                    if(!transferMoney()){
                        System.out.println("Money Transfer Failed!");
                    }
                    break;


                case 6:
                    System.out.println("EXITING...");
                    return;


            }

        }
    }

    public static boolean transferMoney(){
        long account1;

        while(true){
            System.out.print("Enter account number of Sender: ");
            if(!scanner.hasNextLong()){
                System.out.println("Enter numeric value only!");
                scanner.next();
                continue;
            }

            account1=scanner.nextLong();

            if(account1>=1000000000L && account1<=9999999999L){
                break;
            }
            System.out.println("Enter valid 10 digit account number!");
        }

        Account sender=getAccountByNum(account1);

        if(sender==null){
            return false;
        }

        long account2;

        while(true){
            System.out.print("Enter account number of Receiver: ");
            if(!scanner.hasNextLong()){
                System.out.println("Enter numeric value only!");
                scanner.next();
                continue;
            }

            account2=scanner.nextLong();

            if(account2>=1000000000L && account2<=9999999999L){
                break;
            }
            System.out.println("Enter valid 10 digit account number!");
        }

        Account receiver=getAccountByNum(account2);

        if(receiver==null){
            return false;
        }

        double amount;

        while(true){
            System.out.println("Enter value for Withdraw:");

            if(!scanner.hasNextDouble()){
                System.out.println("Enter numeric values only!");
                scanner.next();
                continue;
            }
            amount=scanner.nextDouble();

            if(amount>0 && amount<=sender.getBalance()){
                break;
            }

            System.out.println("Enter valid amount!");
        }

        try {
            sender.withdraw(amount);
        }catch (MinimumBalanceException e){
            System.out.println(e.getMessage());
        }catch (NegativeAmountException e){
            System.out.println(e.getMessage());
        }
        try {
            receiver.deposite(amount);
        }catch (NegativeAmountException e){
            System.out.println(e.getMessage());
        }
        System.out.println(amount+" Rs. transferred from "+account1+" to "+account2);

        return true;
    }



    public static CurrentAccount makeCurrentAccount() {
        scanner.nextLine();
        System.out.print("\nEnter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Minimum Balance: ");
        double minimumBalance = scanner.nextDouble();

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();

        while (true) {
            if (balance < 0 || balance < minimumBalance) {
                System.out.print("Enter valid amount: ");
                balance = scanner.nextDouble();
            } else {
                break;
            }
        }

        CurrentAccount newAcc = new CurrentAccount(name, balance, getUniqueAccountNumber(), minimumBalance);

        System.out.println("Account created successfully!");
        System.out.println("Account No.: " + newAcc.getAccountNumber());
        return newAcc;

    }

    public static SavingsAccount makeSavingsAccount() {
        scanner.nextLine();
        System.out.print("\nEnter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Offer Rate : ");
        double offerRate = scanner.nextDouble();

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();

        while (true) {
            if (balance < 0) {
                System.out.print("Enter valid amount: ");
                balance = scanner.nextDouble();
            } else {
                break;
            }
        }

        SavingsAccount newSavingsAcc = new SavingsAccount(name, balance, getUniqueAccountNumber(),offerRate);
        System.out.println("Account Created Successfully!");
        System.out.println("Account No.: " + newSavingsAcc.getAccountNumber());
        return newSavingsAcc;

    }

    static private Account getAccountByNum(long accountNumber){
        for(int i=0;i<count;i++){
            if(accountNumber==accounts[i].getAccountNumber()){
                return accounts[i];
            }
        }
        return null;
    }

    private static long getUniqueAccountNumber() {
        long newNumber;
        boolean flag;
        do {
            newNumber = random.nextLong(1_000_000_000L, 10_000_000_000L);
            flag = false;

            for (int i = 0; i < count; i++) {
                if (accounts[i].getAccountNumber() == newNumber) {
                    flag = true;
                    break;
                }
            }
        } while (flag);

        return newNumber;
    }

}
