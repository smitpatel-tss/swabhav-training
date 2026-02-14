package STRUCTURAL.Decorator.Assignments.HatMaker.model;

public abstract class HatDecorator implements Hat{
    private Hat hat;

    public HatDecorator(Hat hat){
        this.hat=hat;
    }

    @Override
    public double getPrice() {
        return hat.getPrice();
    }

    @Override
    public String getName() {
        return hat.getName();
    }

    @Override
    public String getDescription() {
        return hat.getDescription();
    }
}
