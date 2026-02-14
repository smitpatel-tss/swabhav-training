package CREATIONAL.Prototype.test;

import CREATIONAL.Prototype.model.Display;
import CREATIONAL.Prototype.model.Phone;

public class PhoneMain {
    public static void main(String[] args) {
        Phone myPhone=new Phone(
                "Samsung",
                "S25",
                "Snapdragon 8 Elite",
                4500,
                new Display(6.2,"2340x1080",120,true));


        System.out.println(myPhone);

        Phone myPhone2=new Phone(myPhone);
        myPhone2.setModelName("S26");
        myPhone2.getDisplay().setSize(5.8);
        myPhone2.setBattery(5000);

        System.out.println(myPhone2);
    }
}
