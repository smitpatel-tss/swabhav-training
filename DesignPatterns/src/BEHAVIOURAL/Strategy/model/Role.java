package BEHAVIOURAL.Strategy.model;

import java.util.List;

public interface Role {
    String getRoleName();
    List<Responsibility> getResponsibilities();
}
