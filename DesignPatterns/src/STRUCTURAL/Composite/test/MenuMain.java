package STRUCTURAL.Composite.test;

import STRUCTURAL.Composite.model.Combo;
import STRUCTURAL.Composite.model.FoodItem;
import STRUCTURAL.Composite.model.MenuUnit;

public class MenuMain {
    public static void main(String[] args) {
        MenuUnit burger = new FoodItem("Burger", 120);
        MenuUnit fries = new FoodItem("Fries", 60);
        MenuUnit coke = new FoodItem("Coke", 40);
        MenuUnit iceCream = new FoodItem("Ice Cream", 80);

        Combo lunchCombo = new Combo("Lunch Combo");
        lunchCombo.add(burger);
        lunchCombo.add(fries);
        lunchCombo.add(coke);

        iceCream.showDetails();

        lunchCombo.showDetails();
        System.out.println("Total Price: "+lunchCombo.getPrice());

    }
}
