package DIP.model;

import java.util.ArrayList;
import java.util.List;

public class DBLogger implements Logger{
    private List<String> logs;
    private boolean state;

    public DBLogger(boolean state) {
        this.state=state;
        this.logs = new ArrayList<>();
    }

    public boolean getState(){
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<String> getLogHistory(){
        return logs;
    }

    public String toString(){
        return "DBLog";
    }

    @Override
    public void registerLogs(String log) {
        logs.add(log);
    }
}
