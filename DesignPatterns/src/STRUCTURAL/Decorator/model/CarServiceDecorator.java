package STRUCTURAL.Decorator.model;

public abstract class CarServiceDecorator implements ICarService{
    private ICarService service;

    public CarServiceDecorator(ICarService service){
        this.service=service;
    }

    @Override
    public double getCost() {
        return service.getCost();
    }
}
