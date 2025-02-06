import java.util.*;
class Bank{
	private String name ; 
	private ArrayList<Customer> customers;
	
	public Bank(String name){
		this.name = name;
		this.customers = new ArrayList<>();
	}
	public void openAccount(String customerName,double initialDeposit){
		Customer customer = new Customer(customerName , this);
		customer.addAccount(new BankAccount(initialDeposit , this));
		customers.add(customer);

	}
	public  void displayCustomers(){
		System.out.println("Customers of "+ name + " Bank:");
		for(Customer customer : customers){
			customer.viewBalance();
		}

	}
	public String getName(){
		return name;
	}
}
class Customer{
	private String name;
	private Bank bank;
	private ArrayList<BankAccount> accounts;

	public Customer(String name , Bank bank){
		this.name = name;
		this.bank = bank;
		this.accounts = new ArrayList<>();

	}
	public void addAccount(BankAccount account){
		accounts.add(account);
	}
	public void viewBalance(){
		System.out.println("Customer : " + name);
		for(BankAccount account : accounts){
			System.out.println("Bank : " + bank.getName() + " , Balance: $" + account.getBalance());
		}
	}
}
class BankAccount{
	private double balance;
	private Bank bank;
	

	public BankAccount(double balance,Bank bank){
		this.balance = balance;
		this.bank = bank;

	}
	public double getBalance(){
		return balance;
	}
}
public class BankSystem{
	public static void main(String args[]){
		Bank bank1 = new Bank("Indian Overseas Bank");
		bank1.openAccount("Samiksha",3000);
		bank1.openAccount("Saniya",5000);

		Bank bank2 = new Bank("State Bank");
		bank2.openAccount("Jiya",7000);

		

		bank1.displayCustomers();
		System.out.println();

	
		bank2.displayCustomers();

	}
}
