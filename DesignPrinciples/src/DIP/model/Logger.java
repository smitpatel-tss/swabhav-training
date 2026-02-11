package DIP.model;

import java.util.List;

public interface Logger {
    void registerLogs(String log);
    List<String> getLogHistory();
    boolean getState();
    void setState(boolean state);
}