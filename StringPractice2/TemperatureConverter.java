import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        convertTemperature();
    }
    
    public static void convertTemperature() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose conversion type:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        int choice = getInput(scanner, "Enter your choice (1 or 2): ");
        
        if (choice == 1) {
            double fahrenheit = getDoubleInput(scanner, "Enter temperature in Fahrenheit: ");
            double celsius = fahrenheitToCelsius(fahrenheit);
            System.out.println("Temperature in Celsius: " + celsius);
        } else if (choice == 2) {
            double celsius = getDoubleInput(scanner, "Enter temperature in Celsius: ");
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.println("Temperature in Fahrenheit: " + fahrenheit);
        } else {
            System.out.println("Invalid choice.");
        }
        
        scanner.close();
    }
    
    public static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    
    public static double getDoubleInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
