package STRUCTURAL.Decorator.Assignments.HatMaker.model;

public class RibbonedHat extends HatDecorator{

    private double ribonnedDecorationPrice=100;

    public RibbonedHat(Hat hat){
        super(hat);
    }
    @Override
    public double getPrice() {
        return super.getPrice()+ribonnedDecorationPrice;
    }

    @Override
    public String getName() {
        return "Ribboned "+super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"\nRibbon Added.";
    }
}
