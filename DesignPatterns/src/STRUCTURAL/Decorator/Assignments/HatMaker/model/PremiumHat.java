package STRUCTURAL.Decorator.Assignments.HatMaker.model;

public class PremiumHat implements Hat{

    private double premiumHatPrice=1000;
    @Override
    public double getPrice() {
        return premiumHatPrice;
    }

    @Override
    public String getName() {
        return "Premium Hat";
    }

    @Override
    public String getDescription() {
        return "It is made using Premium Material.";
    }
}
