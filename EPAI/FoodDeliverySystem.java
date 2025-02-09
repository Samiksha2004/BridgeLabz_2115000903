import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }
    
    public abstract double calculateTotalPrice();
    
    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

interface Discountable {
    double applyDiscount(double percentage);
    String getDiscountDetails();
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_SURCHARGE = 1.2;
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * NON_VEG_SURCHARGE;
    }
    
    public double applyDiscount(double percentage) {
        return calculateTotalPrice() * (1 - percentage / 100);
    }
    
    public String getDiscountDetails() {
        return "Non-veg items have a surcharge of 20%, discount applicable on final price.";
    }
}

public class FoodDeliverySystem {
    public static void processOrder(List<FoodItem> order) {
        for (FoodItem item : order) {
            System.out.println(item.getItemDetails() + ", Total Price: " + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails());
            }
        }
    }
    
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        
        VegItem vegItem = new VegItem("Paneer Butter Masala", 250, 2);
        NonVegItem nonVegItem = new NonVegItem("Chicken Biryani", 350, 1);
        
        order.add(vegItem);
        order.add(nonVegItem);
        
        processOrder(order);
    }
}

