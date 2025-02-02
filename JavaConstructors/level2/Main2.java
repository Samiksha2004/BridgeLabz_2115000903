public class Main2 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234567890", "Alice", 5000.0);
        account.displayAccountDetails();
        
        account.setBalance(5500.0);
        System.out.println("Updated Balance: " + account.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount("0987654321", "Bob", 10000.0);
        savingsAccount.displaySavingsAccountDetails();
    }
}

