package STRUCTURAL.Decorator.test;

import STRUCTURAL.Decorator.model.CarInspection;
import STRUCTURAL.Decorator.model.ICarService;
import STRUCTURAL.Decorator.model.OilChange;
import STRUCTURAL.Decorator.model.WheelAlign;

public class CarServiceMain {
    public static void main(String[] args) {
        ICarService carInspection=new CarInspection();
        WheelAlign wheelAlign=new WheelAlign(carInspection);
        OilChange oilChange=new OilChange(wheelAlign);

        System.out.println(oilChange.getCost());

    }
}
