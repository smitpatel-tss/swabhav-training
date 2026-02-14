package CREATIONAL.AbstractFactory.test;

import CREATIONAL.AbstractFactory.model.BMWFactory;
import CREATIONAL.AbstractFactory.model.Car;
import CREATIONAL.AbstractFactory.model.CarFactory;
import CREATIONAL.AbstractFactory.model.TataFactory;

import java.util.Scanner;


public class CarMain {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        CarFactory tataFactory=new TataFactory();
        CarFactory bmwFactory=new BMWFactory();

        System.out.println("1. Altroz");
        System.out.println("2. Nexon");
        System.out.println("3. BMW M2");
        System.out.print("Choose car object you want to Create:");
        int choice = scanner.nextInt();

        Car myCar=null;

        switch (choice) {
            case 1:
                myCar = tataFactory.makeCar("Altroz");
                break;
            case 2:
                myCar = tataFactory.makeCar("Nexon");
                break;
            case 3:
                myCar=bmwFactory.makeCar("BMWM2");
            default:
                System.out.println("Choose Valid Option!");
        }

        myCar.drive();

    }
}
