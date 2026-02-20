package BEHAVIOURAL.Strategy.model;

public class LeaveApprovals implements Responsibility{
    @Override
    public String getResponsibility() {
        return "Approving Leaves of Employees";
    }
}
