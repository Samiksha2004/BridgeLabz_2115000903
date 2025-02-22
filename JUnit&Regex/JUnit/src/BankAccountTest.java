import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }
        if (balance < amount) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }

    @Test
    void testInsufficientFunds() {
        BankAccount account = new BankAccount(50.0);
        assertThrows(IllegalStateException.class, () -> account.withdraw(100.0));
    }

    @Test
    void testNegativeDeposit() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void testNegativeWithdraw() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }
}
