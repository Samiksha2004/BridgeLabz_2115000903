import java.util.Scanner;

public class GCDLCMCalculator {
    public static void main(String[] args) {
        calculateGCDLCM();
    }
    
    public static void calculateGCDLCM() {
        Scanner scanner = new Scanner(System.in);
        int num1 = getInput(scanner, "Enter first number: ");
        int num2 = getInput(scanner, "Enter second number: ");
        
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);
        
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
        
        scanner.close();
    }
    
    public static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int calculateLCM(int a, int b, int gcd) {
        return (a / gcd) * b;
    }
}

