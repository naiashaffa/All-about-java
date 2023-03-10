package ProjectPemro_1_2023;

public class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem(){
        return item;
    }
    public int getQuantity(){
        return quantity;
    }
    
    public double getPrice(){
        if(item.getName(). equals("Tissu")){
            int bulkSize = 2;               //budle set 2 item
            double bulkPrice = item.getPrice() * 1.5;

            int numBulkGrup = quantity / bulkSize;
            int numNonBulkItem = quantity % bulkSize;

            double total = numBulkGrup * bulkPrice + numNonBulkItem * item.getPrice();
            return total;
        }else if (item.getName(). equals("Apple")){
            int bulkSize = 3;
            double bulkPrice = item.getPrice() * 0.5;

            int numBulkGrup = quantity / bulkSize;
            int numNonBulkItem = quantity % bulkSize;

            double total = numBulkGrup * bulkPrice + numNonBulkItem * item.getPrice();
            return total;
        } else if (item.getName(). equals("Sereal")){
            int bulkSize = 2;
            double bulkPrice = item.getPrice() * 1.0;

            int numBulkGrup = quantity / bulkSize;
            int numNonBulkItem = quantity % bulkSize;

            double total = numBulkGrup * bulkPrice + numNonBulkItem * item.getPrice();
            return total;
        } else
        return quantity * item.getPrice();
    }
}
