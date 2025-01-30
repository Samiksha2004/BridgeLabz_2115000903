import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        checkPrime();
    }
    
    public static void checkPrime() {
        Scanner scanner = new Scanner(System.in);
        int number = getInput(scanner, "Enter a number: ");
        
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
        
        scanner.close();
    }
    
    public static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

