package STRUCTURAL.Facade.test;

import STRUCTURAL.Facade.model.Reception;

public class HotelMain {
    public static void main(String[] args) {

        Reception reception=new Reception();

        reception.checkIn();
        reception.wantFood();
        reception.checkOut();
    }
}
