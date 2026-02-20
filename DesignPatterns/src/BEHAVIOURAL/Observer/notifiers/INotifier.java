package BEHAVIOURAL.Observer.notifiers;

import BEHAVIOURAL.Observer.model.Account;

public interface INotifier {
    void sendAlert(Account account, String change, double amount);
}
