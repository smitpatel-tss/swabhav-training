package GuitarManagement.model;

import java.util.Map;

public class Instrument {
    private String serialNumber;
    private double price;
    private InstrumentSpec specs;

    public Instrument(String serialNumber, double price,InstrumentSpec specs) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.specs=specs;
    }
    public InstrumentSpec getSpecs(){
        return specs;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
