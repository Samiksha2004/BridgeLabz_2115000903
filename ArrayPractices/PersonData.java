import java.util.Scanner;

public class PersonData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();
        
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        
        for (int i = 0; i < number; i++) {
            double height = -1, weight = -1;
            
            while (height <= 0) {
                System.out.print("Enter height for person " + (i + 1) + " (in meters): ");
                height = sc.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be a positive value. Please try again.");
                }
            }

            while (weight <= 0) {
                System.out.print("Enter weight for person " + (i + 1) + " (in kilograms): ");
                weight = sc.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be a positive value. Please try again.");
                }
            }

            double bmi = weight / (height * height);
            
            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = bmi;
            
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }
        
        System.out.println("\nPerson Data (Height, Weight, BMI, Weight Status):");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d - Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s\n", 
                i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}

