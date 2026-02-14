package STRUCTURAL.Adapter.model;

import java.util.List;

public class ShoppingCart {
    List<Items> items;

    public ShoppingCart(List<Items> items){
        this.items=items;
    }

    public void addItems(Items item){
        items.add(item);
        System.out.println(item.getItemName()+" Added to Cart...");
    }

    public double getCartPrice(){
        double total=0;
        for (Items currentItem : items) {
            total+=currentItem.getItemPrice();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("----------------------------------------");
        System.out.printf("%-25s %10s%n", "Item Name", "Price");
        System.out.println("----------------------------------------");

        for (Items currentItem : items) {
            System.out.printf(
                    "%-25s %10.2f%n",
                    currentItem.getItemName(),
                    currentItem.getItemPrice()
            );
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-25s %10s%n", "Total",getCartPrice());
    }


}
