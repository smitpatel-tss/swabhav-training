package DIP.test;

import DIP.model.DBLogger;
import DIP.model.FileLogger;
import DIP.model.LogService;
import DIP.model.Logger;

import java.util.ArrayList;
import java.util.List;

public class LogMain {
    static int limit=5;
    static List<Logger> loggerList=new ArrayList<>();
    static LogService logService=new LogService();
    public static void main(String[] args) throws InterruptedException {

        loggerList.add(new DBLogger(true));
        loggerList.add(new FileLogger(true));
        int currentIndex=0;

        try{
            for(int i=1;i<=12;i++){
                try{
                    if(i>limit){
                        limit+=5;
                        throw new RuntimeException("DATABASE LIMIT REACHED!");
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    loggerList.get(currentIndex).setState(false);
                    System.out.println("Switching Logger...");
                    Thread.sleep(2000);
                    currentIndex++;
                }
                Thread.sleep(500);
                logService.displayLog(loggerList.get(currentIndex),"Calculation step "+i);
            }
        } catch (Exception e) {
            System.out.println("\nALL DATABASE FULL!!!");
        }

        Thread.sleep(200);
        System.out.println("Calculation Over!");

        System.out.println("\nHistory Logs All Databases: ");
        Thread.sleep(2000);

        for(Logger log:loggerList){
            System.out.println("---------------------------------------------");
            logService.displayLogHistory(log);
        }


    }
}
