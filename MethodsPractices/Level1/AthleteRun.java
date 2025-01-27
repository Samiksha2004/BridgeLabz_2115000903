import java.util.Scanner;

public class AthleteRun {
    public static double calculateRounds(double side1, double side2, double side3, double distance) {
        double perimeter = side1 + side2 + side3;
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        double distance = 5000; // 5 km in meters
        double rounds = calculateRounds(side1, side2, side3, distance);

        System.out.println("The athlete needs to complete " + Math.ceil(rounds) + " rounds to complete a 5 km run.");
    }
}

