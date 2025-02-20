import java.util.*;

public class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private Map<Integer, Double> sortedAccounts = new TreeMap<>(Comparator.comparingDouble(accounts::get));
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(accountNumber, balance);
    }

    public void withdrawRequest(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                sortedAccounts.put(accountNumber, accounts.get(accountNumber));
                System.out.println("Withdrawal of " + amount + " processed for Account " + accountNumber);
            } else {
                System.out.println("Insufficient balance for Account " + accountNumber);
            }
        }
    }

    public void displayAccounts() {
        System.out.println("Accounts in HashMap (Unordered): " + accounts);
        System.out.println("Accounts in TreeMap (Sorted by Balance): " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        bank.addAccount(101, 5000.0);
        bank.addAccount(102, 3000.0);
        bank.addAccount(103, 7000.0);
        
        bank.withdrawRequest(102);
        bank.withdrawRequest(103);
        
        bank.processWithdrawals(2000.0);
        bank.displayAccounts();
    }
}
