package OCP.model;

public class FixedDeposit {
    private long accountNumber;
    private Festival festivalType;
    private double duration;
    private double amount;
    private double rate;

    public FixedDeposit(long accountNumber, Festival festivalType, int duration, double amount) {
        this.accountNumber = accountNumber;
        this.festivalType = festivalType;
        this.duration = duration;
        this.amount = amount;
        this.rate=festivalType.getInterestRate();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public Festival getFestivalType() {
        return festivalType;
    }

    public double getDuration() {
        return duration;
    }

    public double getAmount() {
        return amount;
    }
    public double getRate(){
        return rate;
    }
}
