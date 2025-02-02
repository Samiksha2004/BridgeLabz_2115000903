public class Main1 {
    public static void main(String[] args) {
        Book book = new Book("123456789", "Java Programming", "John Doe");
        book.displayBookDetails();
        
        book.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + book.getAuthor());

        EBook eBook = new EBook("987654321", "Advanced Java", "Alice Smith");
        eBook.displayEBookDetails();
    }
}

