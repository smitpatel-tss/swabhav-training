package BEHAVIOURAL.Observer.notifiers;

import BEHAVIOURAL.Observer.model.Account;

public class Email implements INotifier {
    @Override
    public void sendAlert(Account account, String change, double amount) {
        System.out.println("\nEMAIL: ");
        System.out.println("\nSubject: Account Transaction Alert\n");

        System.out.println("Dear " + account.getHolderName() + ",\n");

        System.out.println("We would like to inform you that your account "
                + account.getAccNo()
                + " has been " + change
                + " with Rs. " + amount + ".");

        System.out.println("Your current available balance is Rs. "
                + account.getBalance() + ".\n");

        System.out.println("If you have any questions regarding this transaction, "
                + "please contact customer support.\n");

        System.out.println("Sincerely,");
        System.out.println("Customer Service Team");

    }
}
