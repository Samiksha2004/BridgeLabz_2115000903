public class Book{
	private static String libraryName = "Central Library";
	private String tittle;
	private String author;
	private final String isbn;
	

	public Book(String tittle,String author,String isbn){
		this.tittle = tittle;
		this.author = author;
		this.isbn = isbn;
	
	}
	public static void displayLibraryName(){
		System.out.println("Library Name" + libraryName);
	}
	public void displayBookDetails(){
		if(this instanceof Book){
		System.out.println("Tittle is " + tittle);
		System.out.println("Author is " + author);
		System.out.println("ISBN is " + isbn);
		}
	}
}
