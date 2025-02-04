public class Product{
	private static double discount = 10.0;
	private final int productId;
	private String productName;
	private double price;
	private int quantity;
	
	public Product(int productId,String ProductName,double price,int quantity){
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public static void updateDiscount(double newDiscount){
		discount = newDiscount;
		System.out.println("updated discount : " + discount + " %");	
	}
	public double getDiscountedPrice(){
		return price - (price * discount / 100);
	}
	public void displayProductDetails(){
		if(this instanceof Product){
		System.out.println("Product ID : " + productId);
		System.out.println("Product Name : " + productName);
		System.out.println("Original price : " + price);
		System.out.println("Discounted Price : " + getDiscountedPrice());
		System.out.println("Quantity : " + quantity);
	        }
	}

}
