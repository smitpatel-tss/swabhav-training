package SRP.model;

public class PrintInvoice {
    private TaxCalculator calculator;

    public PrintInvoice(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    public void invoicePrinter(){
        System.out.println("Invoice Details: ");
        System.out.println("Id: "+calculator.myInvoice.getId());
        System.out.println("Description: "+calculator.myInvoice.getDescription());
        System.out.println("Amount: "+calculator.myInvoice.getAmount());
        System.out.println("Applied Tax Percentage: "+(calculator.myInvoice.getTaxPercentage()*100)+" %");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total Amount: "+(calculator.calculateTax()+calculator.myInvoice.getAmount()));
    }
}
