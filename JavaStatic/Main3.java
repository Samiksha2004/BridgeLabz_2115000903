public class Main3{
	public static void main(String args[]){
		Product p1 = new Product(101, "Laptop", 50000, 2);
		Product p2 = new Product(102 , "SmartPhone" ,20000 , 3 );

		System.out.println("\n Product 1 details");
		p1.displayProductDetails();
		
		
		System.out.println();		

		System.out.println("\n Product 2 details");
		p2.displayProductDetails();

		System.out.println();

		Product.updateDiscount(15.0);

		System.out.println("After updating discount");

		System.out.println("\n Product 1 details");
		p1.displayProductDetails();

		System.out.println("\n Product 2 details");
		p2.displayProductDetails();
		
	}
}
