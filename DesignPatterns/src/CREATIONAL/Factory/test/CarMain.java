package CREATIONAL.Factory.test;

import CREATIONAL.Factory.model.Car;
import CREATIONAL.Factory.model.CarFactory;

import java.util.Scanner;

public class CarMain {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Car MyCar=null;
        System.out.println("1. Maruti");
        System.out.println("2. BMW");
        System.out.print("Choose car object you want to Create:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                MyCar = CarFactory.getCar("Maruti");
                break;
            case 2:
                MyCar = CarFactory.getCar("BMW");
                break;
            default:
                System.out.println("Choose Valid Option!");
        }

        MyCar.drive();

    }
}
