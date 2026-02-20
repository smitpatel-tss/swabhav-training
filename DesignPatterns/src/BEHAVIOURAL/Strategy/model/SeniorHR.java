package BEHAVIOURAL.Strategy.model;

import java.util.List;

public class SeniorHR implements Role{

    @Override
    public String getRoleName() {
        return "Senior HR";
    }

    @Override
    public List<Responsibility> getResponsibilities() {
        return List.of(new AttendanceManagement(),new LeaveApprovals());
    }
}
