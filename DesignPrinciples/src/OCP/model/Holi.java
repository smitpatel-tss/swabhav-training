package OCP.model;

public class Holi implements Festival{
    private double rate=5;

    public double getInterestRate(){
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
