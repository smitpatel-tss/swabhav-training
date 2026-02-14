package STRUCTURAL.Decorator.Assignments.HatMaker.test;

import STRUCTURAL.Decorator.Assignments.HatMaker.model.*;

public class HatMain {
    public static void main(String[] args) {
        Hat simpleHat=new StandardHat();
        Hat goldenHat=new GoldenHat(simpleHat);

        System.out.println(goldenHat.getName());
        System.out.println(goldenHat.getDescription());
        System.out.println(goldenHat.getPrice());
    }
}
