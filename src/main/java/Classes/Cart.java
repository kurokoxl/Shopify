package Classes;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Iterator;


public class Cart {
    //Why is there an admin here in the UML??
    private ArrayList<Item> items;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Cart() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public void removeItem(int id){
        if(items.isEmpty())
            return;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if(item.getId() == id){
                iterator.remove();
                break;
            }
        }
    }
    public double getTotalPrice(){
        if(items.isEmpty())
            return 0;
        double result = 0;
        for (Item item : items) {
            double price = item.getPrice();
            double sale = item.getSale() /100;
            result += (price - (price * sale));
        }
        return Double.parseDouble(df.format(result));
    }
    public void emptyCart() {
        if(items.isEmpty())
            return;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }
}
