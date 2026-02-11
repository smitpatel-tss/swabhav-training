package SRP.model;

public class Invoice {
    private int id;
    private String description;
    private double amount;
    private double taxPercentage;

    public Invoice(int id, String description, double amount, double taxPercentage) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.taxPercentage = taxPercentage;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }
}
