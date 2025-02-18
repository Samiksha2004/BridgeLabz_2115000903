import java.util.*;

abstract class WarehouseItem{
    private String name;
    private double price;
    
    public WarehouseItem(String name, double price){
        this.name =  name;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    @Override
    public String toString(){
        return getClass().getSimpleName() + "name:" + name + ",price:" + price ;
    }
}

class Electronics extends WarehouseItem{
    public Electronics(String name, double price){
        super(name, price);
    }
}

class Groceries extends WarehouseItem{
    public Groceries(String name, double price){
        super(name, price);
    }
}

class Furniture extends WarehouseItem{
    public Furniture(String name, double price){
    super(name, price);
    }
}


//generic storage class
class Storage<T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item){
        items.add(item);
    }
    
    public void removeItem(T item){
        items.remove(item);
    }
    
    public List<T> getItems(){
        return items;
    }
    
    //wildcard method 
    public static void displayItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            System.out.println(item);
        }
    }
}

public class SmartWarehouse{
    public static void main(String args[]){
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();
        
        electronicsStorage.addItem(new Electronics("Laptop", 1200.50));
        electronicsStorage.addItem(new Electronics("Smartphone", 800.00));
        
        groceriesStorage.addItem(new Groceries("Apples", 5.99));
        groceriesStorage.addItem(new Groceries("Milk", 3.49));
        
        furnitureStorage.addItem(new Furniture("Sofa", 450.75));
        furnitureStorage.addItem(new Furniture("Dining Table", 700.00));
        
        System.out.println("electronic storage:");
        Storage.displayItems(electronicsStorage.getItems());
        
        System.out.println("\nGroceries storage:");
        Storage.displayItems(groceriesStorage.getItems());
        
        System.out.println("\nFurniture storage:");
        Storage.displayItems(furnitureStorage.getItems());
    }
}
