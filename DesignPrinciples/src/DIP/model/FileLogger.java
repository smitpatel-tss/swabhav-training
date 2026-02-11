package DIP.model;

import java.util.ArrayList;
import java.util.List;

public class FileLogger implements Logger{
    private List<String> logs;
    private boolean state;

    public FileLogger(boolean state){
        this.logs=new ArrayList<>();
        this.state=state;
    }

    @Override
    public String toString() {
        return "FileLog";
    }

    public List<String> getLogHistory(){
        return logs;
    }

    public boolean getState(){
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void registerLogs(String log) {
        logs.add(log);
    }
}
