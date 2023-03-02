package ProjectPemro_1_2023;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> thecart;

    public ShoppingCart(){
        thecart = new ArrayList<ItemOrder>();
    }
    public void add(ItemOrder itemOrder){
        thecart.add(itemOrder);
    }
    public void remove(ItemOrder itemOrder){
        thecart.remove(itemOrder);
    }

    public ItemOrder getItemOrder( String itemName){
        for(ItemOrder itemOrder : thecart){
            if(itemOrder.getItem().getName. equals(itemName)){
                return itemOrder;
            }
        }
        return null;
    }
    public double getTotalPrice(){
        double total = 0;
        for(ItemOrder itemOrder : thecart){
            total += itemOrder.getPrice();
        }
        return total;
    }
    public void printThecart(){
        System.out.println ("SHOP RECEIPT");
        System.out.println("******************");
        System.out.println("The items : ");
        for(ItemOrder itemOrder : thecart){
            System.out.println(itemOrder.getQuantity()+ " " + itemOrder.getItem().getName());
        }
        System.out.println("******************");
    }
    public void getItemOrder(ItemOrder itemOrder3) {
    }
}
