package BEHAVIOURAL.Observer.test;

import BEHAVIOURAL.Observer.model.Account;
import BEHAVIOURAL.Observer.notifiers.Email;
import BEHAVIOURAL.Observer.notifiers.INotifier;
import BEHAVIOURAL.Observer.notifiers.SMS;
import BEHAVIOURAL.Observer.notifiers.WhatsApp;

import java.util.ArrayList;
import java.util.List;

public class AccountMain {
    public static void main(String[] args) {
        List<INotifier> notifierList=new ArrayList<>();

//        System.out.println("");

        notifierList.add(new SMS());
        notifierList.add(new WhatsApp());
        notifierList.add(new Email());

        Account account1=new Account("Smit Patel",50000,notifierList);

        account1.withdraw(5000);
        account1.deposit(10000);
    }
}
