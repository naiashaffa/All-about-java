package ProjectPemro_1_2023;
public class NaiaListPP01 {
    public static void main(String [] args){
        Item tissu = new Item("Tissu", 4.0);
        Item apple = new Item("Apple", 1.0);
        Item sereal = new Item("Sereal", 6.0);
        ItemOrder itemOrder1 = new ItemOrder(tissu, 6);
        ItemOrder itemOrder2 = new ItemOrder(apple, 3);
        ItemOrder itemOrder3 = new ItemOrder(sereal, 2);
        

        ShoppingCart cart = new ShoppingCart();
        cart.add(itemOrder1);
        cart.add(itemOrder2);
        cart.add(itemOrder3);

        cart.printThecart();
        System.out.println("Total price: " + cart.getTotalPrice());
    }
}
