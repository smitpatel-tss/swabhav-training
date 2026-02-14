package STRUCTURAL.Decorator.model;

public class CarInspection implements ICarService{
    private double carInspectionCost=1000;
    public double getCost(){
        return carInspectionCost;
    }
}
