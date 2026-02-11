package ISP.model;

public class TSSEmployee implements Human{
    @Override
    public void eat() {
        System.out.println("Eating in Canteen!");
    }
    public void rest(){
        System.out.println("Resting in Peace........");
    }
}
