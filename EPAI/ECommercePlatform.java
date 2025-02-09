import java.util.*;

abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public abstract double calculateDiscount();
    
    public double getFinalPrice() {
        return price - calculateDiscount();
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }
    
    public double calculateTax() {
        return getPrice() * 0.15;
    }
    
    public String getTaxDetails() {
        return "Electronics Tax: 15%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }
    
    public double calculateTax() {
        return getPrice() * 0.05;
    }
    
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void printFinalPrice(List<Product> products) {
        for (Product product : products) {
            double tax = product instanceof Taxable ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getFinalPrice() + tax;
            System.out.println("Product: " + product.getName() + ", Final Price: " + finalPrice);
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
        }
    }
    
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        Electronics laptop = new Electronics(101, "Laptop", 50000);
        Clothing tshirt = new Clothing(102, "T-Shirt", 1000);
        Groceries apple = new Groceries(103, "Apple", 200);
        
        products.add(laptop);
        products.add(tshirt);
        products.add(apple);
        
        printFinalPrice(products);
    }
}

