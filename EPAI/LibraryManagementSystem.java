import java.util.*;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    
    public String getItemId() {
        return itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
    
    public abstract int getLoanDuration();
}

interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    public int getLoanDuration() {
        return 14; // 14 days loan duration
    }
    
    public boolean reserveItem() {
        return true; // Assume reservation is always successful
    }
    
    public boolean checkAvailability() {
        return true; // Assume always available
    }
}

class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    public int getLoanDuration() {
        return 7; // 7 days loan duration
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    public int getLoanDuration() {
        return 3; // 3 days loan duration
    }
    
    public boolean reserveItem() {
        return true;
    }
    
    public boolean checkAvailability() {
        return true;
    }
}

public class LibraryManagementSystem {
    public static void processLibraryItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails() + ", Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                System.out.println("Reservable: " + ((Reservable) item).checkAvailability());
            }
        }
    }
    
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        
        Book book = new Book("B101", "Java Programming", "James Gosling");
        Magazine magazine = new Magazine("M202", "Tech Today", "Editorial Team");
        DVD dvd = new DVD("D303", "Inception", "Christopher Nolan");
        
        items.add(book);
        items.add(magazine);
        items.add(dvd);
        
        processLibraryItems(items);
    }
}

