import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int index = scanner.nextInt();
        int divisor = scanner.nextInt();
        
        try {
            int element;
            try {
                element = arr[index];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
                return;
            }
            try {
                int result = element / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } finally {
            scanner.close();
        }
    }
}

