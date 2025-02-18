import java.util.*;
abstract class ProductCategory{
    private String categoryName;
    
    public ProductCategory(String categoryName ){
        this.categoryName = categoryName;
    }
    
    public String getCategoryName(){
        return categoryName;
    }
}

class BookCategory extends ProductCategory{
    public BookCategory(){
        super("Books");
    }
}

class ClothingCategory extends ProductCategory{
    public ClothingCategory(){
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory{
    public GadgetCategory(){
        super("Gadgets");
    }
}

class Product<T extends ProductCategory>{
    private String name;
    private double price;
    private T category;
    
    public Product(String name, double price, T category){
        this.name = name ;
        this.price = price;
        this.category = category;
        
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public T getCategory(){
        return category;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "product:" + name + ", category:" + category.getCategoryName() + ", price:" + price ;
        
    }
}


class Marketplace{
    private List<Product<?>> catalog = new ArrayList<>();
    
    public void addProduct(Product<?>product){
        catalog.add(product);
    }
    
    public void showCatalog(){
        System.out.println("\nMarketplace catalog");
        for(Product<?> product : catalog){
            System.out.println(product);
        }
    }
    
    public static <T extends Product<?>> void applyDiscount(T product, double percentage){
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
        System.out.println("applied" + percentage + "%discount to" + product.getName() + ",new price:" + product.getPrice());
    }
}

public class OnlineMarketplace{
    public static void main(String args[]){
        Product<BookCategory> book1 = new Product<>("Java Programming", 39.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 25.50, new ClothingCategory());
        Product<GadgetCategory> smartphone = new Product<>("Smartphone ", 799.99, new GadgetCategory());

        //created marketplace and added products
        Marketplace marketplace = new Marketplace();
        marketplace.addProduct(book1);
        marketplace.addProduct(shirt);
        marketplace.addProduct(smartphone);
        
        //display
        marketplace.showCatalog();
        
        Marketplace.applyDiscount(book1, 10);
        Marketplace.applyDiscount(shirt, 20);
        Marketplace.applyDiscount(smartphone, 25);
        
        marketplace.showCatalog();
    }
}
