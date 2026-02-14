package STRUCTURAL.Decorator.model;

public class OilChange extends CarServiceDecorator{

    private double oilChangeCost=500;

    public OilChange(ICarService service){
        super(service);
    }

    public double getCost(){
        return (super.getCost()+oilChangeCost);
    }
}
