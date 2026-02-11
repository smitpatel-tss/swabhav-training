package ISP.model;

public interface Workable {
    default void doWork(){
        System.out.println("Working...");
    }
}
