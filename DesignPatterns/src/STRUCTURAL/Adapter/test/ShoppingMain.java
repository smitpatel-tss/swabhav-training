package STRUCTURAL.Adapter.test;

import STRUCTURAL.Adapter.model.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMain {
    public static void main(String[] args) {

        List<Items> items=new ArrayList<>();

        ShoppingCart cart=new ShoppingCart(items);

        cart.addItems(new Biscuit(10,"Parle G"));
        cart.addItems(new Chocolate(100,"5 star"));
        cart.addItems(new HatAdapter(new Hat("Joker Vali Topi","Topi",100,15)));

        cart.displayCart();

    }

}
