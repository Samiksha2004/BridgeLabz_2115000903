class Movie{
	String title;
	String director;
	int year;
	double rating;
	Movie next , prev;

	public Movie(String title,String director,int year,double rating){
		this.title = title;
		this.director = director;
		this.year = year;
		this.rating = rating;
		this.next = this.prev = null;
	}
}
class MovieManagementSystem{
	private Movie head , tail;

	public void addAtBeginning(String title,String director,int year,double rating){
		Movie newMovie = new Movie(title,director,year,rating);
		if(head == null){
		    head = tail = newMovie;
		    return;	
		}
		newMovie.next = head;
		head.prev = newMovie;
		head = newMovie;
	}
	public void addAtEnd(String title,String director,int year,double rating){
		Movie newMovie = new Movie(title,director,year,rating);
		if(tail == null){
		  head = tail = newMovie;
		  return;
		}
		tail.next = newMovie;
		newMovie.prev = tail;
		tail = newMovie;
	}
	public void addAtPosition(int position,String title,String director,int year,double rating){
		if(position < 1) return;
		if(position == 1){
			addAtBeginning(title,director,year,rating);
			return;
		}
		Movie newMovie = new Movie(title,director,year,rating);
		Movie temp = head;
		for(int i=1 ; temp != null && i < position - 1;i++){
			temp = temp.next;
		}
		if(temp == null || temp.next == null){
			addAtEnd(title,director,year,rating);
			return ;
		}
		newMovie.next = temp.next;
		temp.next.prev = newMovie;
		temp.next = newMovie;
		newMovie.prev = temp;
	}
	public void removeByTitle(String title){
		Movie temp = head;
		while(temp != null && !temp.title.equals(title)){
			temp = temp.next;
		}
		if(temp == null) return;
		if(temp == head){
			head = head.next;
			if(head != null) head.prev = null;
		}else if(temp == tail){
			tail = tail.prev;
			if(tail != null) tail.next = null;
		}else{
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		
		}
	}
	public Movie searchByDirector(String director){
		Movie temp = head;
		while(temp != null){
			if(temp.director.equals(director)) return temp;
			temp = temp.next;
		}
		return null;
	}
	public Movie searchByRating(double rating){
		Movie temp = head;
		while(temp != null){
			if(temp.rating == rating) return temp;
			temp = temp.next;
		}
		return null;
	}
	public void updateRating(String title,double newRating){
		Movie temp = head;
		while(temp != null){
			if(temp.title.equals(title)){
				temp.rating = newRating;
				return;
			}
			temp = temp.next;
		}
	}
	public void displayForward(){
		Movie temp = head;
		while(temp != null){
		System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
		temp = temp.next;
		}
	}
	public void displayReverse(){
		Movie temp = tail;
		while(temp != null){
		System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
                temp = temp.prev;

		}
	}
}
public class Main1{
	public static void main(String args[]){
		MovieManagementSystem mms = new MovieManagementSystem();
		 mms.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
                 mms.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
                 mms.addAtBeginning("The Dark Knight", "Christopher Nolan", 2008, 9.0);
                 mms.addAtPosition(2, "Memento", "Christopher Nolan", 2000, 8.4);


		 System.out.println("Movies in Forward Order:");
                 mms.displayForward();
        
                 System.out.println("\nMovies in Reverse Order:");
                 mms.displayReverse();

		 System.out.println("\nUpdating rating of 'Inception' to 9.0");
       		 mms.updateRating("Inception", 9.0);
       		 mms.displayForward();
        
        	System.out.println("\nSearching for movies directed by 'Christopher Nolan'");
       		 Movie found = mms.searchByDirector("Christopher Nolan");
        		if (found != null) {
           			 System.out.println("Found: " + found.title);
        		} else {
            			System.out.println("Not found.");
        		}
        
        	System.out.println("\nRemoving 'Memento'");
        	mms.removeByTitle("Memento");
        	mms.displayForward();
           }
}
