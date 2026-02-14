package STRUCTURAL.Adapter.model;

public class Chocolate implements Items {
    private double chocolatePrice;
    private String name;

    public Chocolate(double chocolatePrice, String name) {
        this.chocolatePrice = chocolatePrice;
        this.name = name;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public double getItemPrice() {
        return chocolatePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChocolatePrice(double chocolatePrice) {
        this.chocolatePrice = chocolatePrice;
    }
}
