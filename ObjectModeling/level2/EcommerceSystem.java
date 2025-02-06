import java.util.*;

class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private List<Product> products;
    private static int orderCounter = 1;

    public Order() {
        this.orderId = orderCounter++;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products in order:");
        for (Product product : products) {
            System.out.println("- " + product.getProductName() + " ($" + product.getPrice() + ")");
        }
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayCustomerOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

public class EcommerceSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice");

        Product p1 = new Product("Laptop", 1000);
        Product p2 = new Product("Smartphone", 700);
        Product p3 = new Product("Headphones", 100);

        Order order1 = new Order();
        order1.addProduct(p1);
        order1.addProduct(p3);

        Order order2 = new Order();
        order2.addProduct(p2);

        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        customer1.displayCustomerOrders();
    }
}

