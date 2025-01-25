import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");

            while (true) {
                System.out.print("Enter salary: ");
                salaries[i] = scanner.nextDouble();
                if (salaries[i] > 0) {
                    break;
                } else {
                    System.out.println("Invalid salary. Please enter a positive number.");
                }
            }

            while (true) {
                System.out.print("Enter years of service: ");
                yearsOfService[i] = scanner.nextDouble();
                if (yearsOfService[i] >= 0) {
                    break;
                } else {
                    System.out.println("Invalid years of service. Please enter a non-negative number.");
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05;
            } else {
                bonuses[i] = salaries[i] * 0.02;
            }

            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("\nSummary of Bonus Calculation:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f%n",
                              i + 1, salaries[i], bonuses[i], newSalaries[i]);
        }

        System.out.printf("\nTotal Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f%n", totalBonus);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);

        
    }
}

