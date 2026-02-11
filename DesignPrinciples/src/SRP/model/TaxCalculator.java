package SRP.model;

public class TaxCalculator {
    Invoice myInvoice;

    public TaxCalculator(Invoice myInvoice) {
        this.myInvoice = myInvoice;
    }

    public double calculateTax(){
        return myInvoice.getAmount()*myInvoice.getTaxPercentage();
    }
}
