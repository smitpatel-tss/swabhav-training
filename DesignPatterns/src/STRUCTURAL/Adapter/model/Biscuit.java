package STRUCTURAL.Adapter.model;

public class Biscuit implements Items{
    private double biscuitPrice;
    private String name;

    public Biscuit(double biscuitPrice, String name) {
        this.biscuitPrice = biscuitPrice;
        this.name = name;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public double getItemPrice() {
        return biscuitPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBiscuitPrice(double biscuitPrice) {
        this.biscuitPrice = biscuitPrice;
    }

}
