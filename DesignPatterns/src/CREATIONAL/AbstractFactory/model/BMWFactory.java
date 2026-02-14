package CREATIONAL.AbstractFactory.model;

public class BMWFactory implements CarFactory{

    public Car makeCar(String carName){
        if(carName.equalsIgnoreCase("BmwM2")){
            return new BmwM2();
        }
        return null;
    }
}
