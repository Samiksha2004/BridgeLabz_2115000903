import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            int counter = 1;
            while (counter <= n) {
                loopSum += counter;
                counter++;
            }
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);
            System.out.println(formulaSum == loopSum ? "Both computations are correct." : "There is a discrepancy in the results.");
        }
        
    }
}

