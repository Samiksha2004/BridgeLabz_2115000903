import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();
        
        double[][] personData = new double[numPersons][3];
        String[] weightStatus = new String[numPersons];
        
        for (int i = 0; i < numPersons; i++) {
            do {
                System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
                personData[i][0] = scanner.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Weight must be positive. Please enter again.");
                }
            } while (personData[i][0] <= 0);
            
            do {
                System.out.print("Enter height (m) of person " + (i + 1) + ": ");
                personData[i][1] = scanner.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Height must be positive. Please enter again.");
                }
            } while (personData[i][1] <= 0);
        }
        
        for (int i = 0; i < numPersons; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("Height (m)\tWeight (kg)\tBMI\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s%n", 
                personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
        
        
    }
}

