import java.util.Scanner;

public class NumberChecker {

    public static String isPositive(int number) {
        if (number >= 0) {
            return "positive";
        } else {
            return "negative";
        }
    }

    public static String isEven(int number) {
        if (number % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            String sign = isPositive(numbers[i]);
            if (sign.equals("positive")) {
                String evenOdd = isEven(numbers[i]);
                System.out.println(numbers[i] + " is " + sign + " and " + evenOdd + ".");
            } else {
                System.out.println(numbers[i] + " is " + sign + ".");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        if (comparisonResult == 1) {
            System.out.println("The first number is greater than the last number.");
        } else if (comparisonResult == 0) {
            System.out.println("The first number is equal to the last number.");
        } else {
            System.out.println("The first number is less than the last number.");
        }
    }
}
