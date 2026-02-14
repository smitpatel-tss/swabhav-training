package CREATIONAL.Factory.model;

public class CarFactory {

    public static Car getCar(String carName){
        if(carName.equalsIgnoreCase("bmw")){
            return new BMW();
        }
        if(carName.equalsIgnoreCase("Maruti")){
            return new Maruti();
        }
        return null;
    }

}
