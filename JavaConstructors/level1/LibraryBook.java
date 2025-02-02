public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean availability;

    public LibraryBook(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("The book '" + title + "' has been borrowed.");
        } else {
            System.out.println("The book '" + title + "' is not available for borrowing.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", 300.0, true);
        LibraryBook book2 = new LibraryBook("1984", "George Orwell", 250.0, false);

        book1.borrowBook();
        book2.borrowBook();
    }
}

