package ProjectPemro_1_2023;

class ShoppingCart {
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

    public ItemOrder search(Item name){
        for(ItemOrder itemoOrder : thecart){
            if(itemOrder.getItem().getName. equals(itemName)){
                return itemoOrder;
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
    public voud printThecart(){
        System.out.println
    }
}
