import java.util.*;

public class ShoppingCart {
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Double> orderedItems = new LinkedHashMap<>();
    private Map<String, Double> sortedItems = new TreeMap<>(Comparator.comparingDouble(priceMap::get));

    public void addItem(String item, double price) {
        priceMap.put(item, price);
        orderedItems.put(item, price);
        sortedItems.put(item, price);
    }

    public void displayCart() {
        System.out.println("Items in HashMap (Unordered): " + priceMap);
        System.out.println("Items in LinkedHashMap (Insertion Order): " + orderedItems);
        System.out.println("Items in TreeMap (Sorted by Price): " + sortedItems);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.addItem("Laptop", 1500.0);
        cart.addItem("Phone", 800.0);
        cart.addItem("Headphones", 200.0);
        cart.addItem("Monitor", 300.0);
        
        cart.displayCart();
    }
}
