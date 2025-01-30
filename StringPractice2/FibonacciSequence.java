import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        generateFibonacci();
    }
    
    public static void generateFibonacci() {
        Scanner scanner = new Scanner(System.in);
        int terms = getInput(scanner, "Enter the number of terms: ");
        
        System.out.println("Fibonacci Sequence:");
        printFibonacci(terms);
        
        scanner.close();
    }
    
    public static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    
    public static void printFibonacci(int terms) {
        int first = 0, second = 1;
        for (int i = 0; i < terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
}

