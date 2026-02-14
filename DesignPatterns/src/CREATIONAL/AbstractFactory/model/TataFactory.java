package CREATIONAL.AbstractFactory.model;

public class TataFactory implements CarFactory{
    public Car makeCar(String carName){
        if(carName.equalsIgnoreCase("Altroz")){
            return new Altroz();
        }
        if(carName.equalsIgnoreCase("Nexon")){
            return new Nexon();
        }
        return null;
    }
}
