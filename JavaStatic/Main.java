public class Main{
	public static void main(String args[]){
		BankAccount acc1 = new BankAccount("Alice", 1001, 5000.0);
		BankAccount acc2 = new BankAccount("Bob", 1002, 7000.0);

		acc1.displayAccountDetails();
		System.out.println();
		acc2.displayAccountDetails();

		System.out.println("Total Accounts " + BankAccount.getTotalAccounts());
	}	
}
