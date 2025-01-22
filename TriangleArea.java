import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base of the triangle in inches: ");
        double baseInches = input.nextDouble();

        System.out.print("Enter the height of the triangle in inches: ");
        double heightInches = input.nextDouble();

       
        double areaInches = 0.5 * baseInches * heightInches;

        double baseCm = baseInches * 2.54;
        double heightCm = heightInches * 2.54;

        double areaCm = 0.5 * baseCm * heightCm;

        System.out.println("The area of the triangle in square inches is: " + areaInches + " square inches.");
        System.out.println("The area of the triangle in square centimeters is: " + areaCm + " square centimeters.");

       
    }
}

