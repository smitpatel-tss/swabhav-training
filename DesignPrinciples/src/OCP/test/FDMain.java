package OCP.test;

import OCP.model.Diwali;
import OCP.model.FDServices;
import OCP.model.FixedDeposit;

public class FDMain {
    public static void main(String[] args) {
        FixedDeposit fd=new FixedDeposit(143,new Diwali(),3,50000);
        FDServices fdDetails=new FDServices(fd);

        fdDetails.fdPrinter();
    }
}
