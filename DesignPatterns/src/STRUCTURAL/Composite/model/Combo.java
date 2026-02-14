package STRUCTURAL.Composite.model;

import java.util.ArrayList;
import java.util.List;

public class Combo implements MenuUnit{
    private String comboName;
    private List<MenuUnit> comboItems=new ArrayList<>();

    public Combo(String comboName){
        this.comboName=comboName;
    }

    public void add(MenuUnit item){
        comboItems.add(item);
    }

    public void remove(MenuUnit item){
        comboItems.remove(item);
    }

    @Override
    public void showDetails() {
        System.out.println(comboName+":");
        for(MenuUnit item : comboItems){
            item.showDetails();
        }
    }

    @Override
    public double getPrice() {
        double totalPrice=0;

        for(MenuUnit item : comboItems){
            totalPrice+=item.getPrice();
        }
        return totalPrice;
    }
}
