public class BankAccount{
	private static String bankName = "XYZ Bank";
	private static int totalAccounts = 0;
	
	private String accountHolderName;
	private final int accountNumber;
	private double balance;

	public BankAccount(String accountHolderName,int accountNumber,double initialBalance){
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
		totalAccounts++;
		
	}
	public static int getTotalAccounts(){
		return totalAccounts;
	
	}
	public void displayAccountDetails(){
		if(this instanceof BankAccount){
			System.out.println("Bank name " + bankName);
			System.out.println("Account Holder " + accountHolderName);
			System.out.println("Account Number " + accountNumber);
			System.out.println("Balance " + balance);
		}	
	}
	
}
