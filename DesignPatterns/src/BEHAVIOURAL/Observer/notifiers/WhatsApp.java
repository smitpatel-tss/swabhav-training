package BEHAVIOURAL.Observer.notifiers;

import BEHAVIOURAL.Observer.model.Account;

public class WhatsApp implements INotifier{
    @Override
    public void sendAlert(Account account, String change, double amount) {
        System.out.println("\nWhatsApp: ");
        System.out.println("\n*Bank Transaction Alert*");
        System.out.println("Dear " + account.getHolderName() + ",");
        System.out.println("Your A/c " + account.getAccNo() +
                " has been " + change +
                " with Rs. " + amount + ".");
        System.out.println("Available Balance: Rs. " +
                account.getBalance() + ".");
        System.out.println("For any queries, contact customer support.");
        System.out.println("- Your Bank");
    }
}
