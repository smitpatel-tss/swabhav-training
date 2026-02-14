package STRUCTURAL.Decorator.Assignments.HatMaker.model;

public class StandardHat implements Hat{

    private double standardHatPrice=1000;
    @Override
    public double getPrice() {
        return standardHatPrice;
    }

    @Override
    public String getName() {
        return "Standard Hat";
    }

    @Override
    public String getDescription() {
        return "It is made using Normal Material.";
    }
}
