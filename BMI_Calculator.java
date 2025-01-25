import java.util.Scanner;

public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numberOfPersons = scanner.nextInt();

        double[] heights = new double[numberOfPersons];
        double[] weights = new double[numberOfPersons];
        double[] bmis = new double[numberOfPersons];
        String[] statuses = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            System.out.print("Enter weight (in kg) of person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 25) {
                statuses[i] = "Normal";
            } else if (bmis[i] < 40) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        System.out.println("Height\tWeight\tBMI\tStatus");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s%n", heights[i], weights[i], bmis[i], statuses[i]);
        }

        
    }
}
