package SRP.test;

import SRP.model.Invoice;
import SRP.model.PrintInvoice;
import SRP.model.TaxCalculator;

public class InvoiceMain {
    public static void main(String[] args) {
        TaxCalculator calculator=new TaxCalculator(new Invoice(1,"Cheese Popcorn",15500,0.05));
        PrintInvoice printer=new PrintInvoice(calculator);
        printer.invoicePrinter();
    }
}
