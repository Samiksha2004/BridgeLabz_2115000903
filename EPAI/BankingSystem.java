import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
    
    public abstract double calculateInterest();
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04;
    
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
    
    public boolean applyForLoan(double amount) {
        return getBalance() >= amount * 0.5;
    }
    
    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit = 5000;
    
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    public double calculateInterest() {
        return 0; // No interest for current accounts
    }
}

public class BankingSystem {
    public static void processAccounts(List<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getAccountNumber() + ", Holder: " + account.getHolderName() + ", Interest: " + account.calculateInterest());
            if (account instanceof Loanable) {
                System.out.println("Loan Eligibility: " + ((Loanable) account).calculateLoanEligibility());
            }
        }
    }
    
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        
        SavingsAccount savings = new SavingsAccount("SAV123", "Alice", 10000);
        CurrentAccount current = new CurrentAccount("CUR456", "Bob", 5000);
        
        accounts.add(savings);
        accounts.add(current);
        
        processAccounts(accounts);
    }
}

