package OCP.model;

public class FDServices {
    FixedDeposit fd;

    public FDServices(FixedDeposit fd) {
        this.fd = fd;
    }

    public double interestCalculator(){
        return (fd.getAmount()*fd.getDuration()*fd.getRate())/100;
    }

    public void fdPrinter(){
        System.out.println("Account Number  : " + fd.getAccountNumber());
        System.out.println("Amount          : " + fd.getAmount());
        System.out.println("Duration        : " + fd.getDuration());
        System.out.println("Rate            : " + fd.getRate());
        System.out.println("Interest        : " + interestCalculator());
        System.out.println("---------------------------------------------------------");
        System.out.println("Total Amount    : "+(interestCalculator()+fd.getAmount()));
    }
}
