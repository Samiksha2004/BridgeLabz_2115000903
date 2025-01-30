import java.util.Scanner;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        calculateFactorial();
    }
    
    public static void calculateFactorial() {
        Scanner scanner = new Scanner(System.in);
        int number = getInput(scanner, "Enter a number: ");
        
        long result = factorial(number);
        System.out.println("The factorial of " + number + " is: " + result);
        
        scanner.close();
    }
    
    public static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    
    public static long factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
