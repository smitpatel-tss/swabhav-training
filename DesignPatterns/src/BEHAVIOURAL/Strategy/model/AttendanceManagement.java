package BEHAVIOURAL.Strategy.model;

public class AttendanceManagement implements Responsibility{
    @Override
    public String getResponsibility() {
        return "Managing attendance of employees";
    }
}
