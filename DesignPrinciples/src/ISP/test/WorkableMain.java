package ISP.test;

import ISP.model.Human;
import ISP.model.TSSEmployee;
import ISP.model.Workable;

public class WorkableMain {
    public static void main(String[] args) {
        Human tanmay=new TSSEmployee();
        tanmay.doWork();
        tanmay.eat();
        tanmay.rest();
    }
}
