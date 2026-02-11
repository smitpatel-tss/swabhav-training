package OCP.model;

public class NewYear implements Festival{
    private double rate=6;
    public double getInterestRate(){
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
