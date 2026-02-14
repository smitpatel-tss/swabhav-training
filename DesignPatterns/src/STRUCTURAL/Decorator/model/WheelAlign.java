package STRUCTURAL.Decorator.model;

public class WheelAlign extends CarServiceDecorator{
    private double wheelAlignCost=400;

    public WheelAlign(ICarService service){
        super(service);
    }

    public double getCost(){
        return (super.getCost()+wheelAlignCost);
    }
}
