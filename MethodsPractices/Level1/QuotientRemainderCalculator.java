import java.util.Scanner;

public class QuotientRemainderCalculator {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor; // Calculate quotient
        int remainder = number % divisor; // Calculate remainder
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();
        if (divisor == 0) {
            System.out.println("Division by zero is not allowed.");
        } else {
            // Call the method to get quotient and remainder
            int[] result = findRemainderAndQuotient(number, divisor);
            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        }
    }
}
