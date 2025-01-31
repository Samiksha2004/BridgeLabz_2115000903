public class Main2 {
    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 299.99);
        Book book2 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 399.50);

        System.out.println("=== Book 1 Details ===");
        book1.displayDetails();

        System.out.println("\n=== Book 2 Details ===");
        book2.displayDetails();
    }
}

