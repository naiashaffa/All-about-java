package ProjectPemro_1_2023;

public class NaiaListPP01 {
    public static void main(String [] args){
        Item tissu = new Item("Tissu", 4.0);
        Item apple = new Item("Apple", 1.0);
        Item sereal = new Item("Sereal", 6.0);

        ShoppingCart cart = new ShoppingCart();
        cart.addItemOrder(ItemOrder1);
        cart.addItemOrder(ItemOrder2);
        cart.addItemOrder(ItemOrder3);

        cart.printThecart();
        System.our.println("Total price: " + cart.getTotalPrice());
    }
}
