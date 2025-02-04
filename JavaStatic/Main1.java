public class Main1{
	public static void main(String args[]){
		Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
		Book b2 = new Book("1984", "George Orwell", "9780451524935");

		System.out.println("\n Book1 details");
		b1.displayBookDetails();

		System.out.println("\n Book2 details");
		b2.displayBookDetails();
}	


}
