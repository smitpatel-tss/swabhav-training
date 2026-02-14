package STRUCTURAL.Composite.model;

public class FoodItem implements MenuUnit{
    private String name;
    private double price;

    public FoodItem(String name,double price){
        this.name=name;
        this.price=price;
    }

    @Override
    public void showDetails() {
        System.out.println(name+" : "+price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
