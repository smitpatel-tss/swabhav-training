package STRUCTURAL.Adapter.model;

public class HatAdapter implements Items{
    private Hat hat;

    public HatAdapter(Hat hat){
        this.hat=hat;
    }

    public String getItemName() {
        return hat.getLongName()+" "+hat.getShortName();
    }

    @Override
    public double getItemPrice() {
        return hat.getBasePrice()+hat.getTax();
    }
}
