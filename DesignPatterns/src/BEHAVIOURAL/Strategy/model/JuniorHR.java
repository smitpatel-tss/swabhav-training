package BEHAVIOURAL.Strategy.model;

import java.util.List;

public class JuniorHR implements Role{
    @Override
    public String getRoleName() {
        return "Junior HR";
    }

    @Override
    public List<Responsibility> getResponsibilities() {
        return List.of(new AttendanceManagement());
    }
}
