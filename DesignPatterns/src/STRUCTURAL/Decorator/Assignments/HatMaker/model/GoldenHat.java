package STRUCTURAL.Decorator.Assignments.HatMaker.model;

public class GoldenHat extends HatDecorator{
    private double goldenDecorationPrice=300;

    public GoldenHat(Hat hat){
        super(hat);
    }
    @Override
    public double getPrice() {
        return super.getPrice()+goldenDecorationPrice;
    }

    @Override
    public String getName() {
        return "Golden "+super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"\nGolden Decoration Added.";
    }
}
