package BEHAVIOURAL.Observer.notifiers;

import BEHAVIOURAL.Observer.model.Account;

public class SMS implements INotifier{
    @Override
    public void sendAlert(Account account, String change, double amount) {
        System.out.println("\nSMS: ");
        System.out.println("\nDear " + account.getHolderName() +
                ", your account " + account.getAccNo() +
                " has been "+change+" with Rs. " + amount +
                ". Available balance: Rs. " + account.getBalance() + ".");
    }
}
