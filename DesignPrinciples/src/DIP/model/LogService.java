package DIP.model;

public class LogService {

    public void displayLogHistory(Logger log) {
        if(log.getLogHistory().isEmpty()){
            System.out.println("No Logs Registered yet!");
            return;
        }
        for(String logs:log.getLogHistory()){
            System.out.println(log+": "+logs);
        }
    }


    public void displayLog(Logger log,String message){
        if(log.getState()){
            System.out.println(log+": "+message);
            log.getLogHistory().add(message);
            return;
        }
        throw new RuntimeException("DB is Not Active!");
    }

}
