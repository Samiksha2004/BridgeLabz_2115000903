import java.util.*;
class Book{
	private String tittle ; 
	private String author;
	
	public Book(String tittle,String author){
		this.tittle = tittle;
		this.author = author;
	}
	public String getTittle(){
		return tittle;
	}
	public String getAuthor(){
		return author;
	}
	public void displayBook(){
		System.out.println("Tittle: " + tittle + " , Author: " + author );
	}
	
}
class Library{
	private ArrayList<Book> books;

	public Library(){
		books = new ArrayList<>();
	}
	public void addBook(Book book){
		books.add(book);
	}
	public void displayBooks(){
		for(Book book : books){
			book.displayBook();
		}
	}
}
public class LibrarySystem{
	public static void main(String args[]){
		Book book1 = new Book("The Alchemist", "Paulo Coelho");
		Book book2 = new Book("1984", "George Orwell");

		Library library1 = new Library();
		library1.addBook(book1);
		library1.addBook(book2);

		System.out.println("Library 1 books are ");
		library1.displayBooks();

		Library library2 = new Library();
		library2.addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));

		System.out.println("\n Library 2 books are ");
		library2.displayBooks();
	}
}
