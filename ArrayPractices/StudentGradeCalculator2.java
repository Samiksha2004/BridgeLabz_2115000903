import java.util.Scanner;

public class StudentGradeCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        int[][] marks = new int[numStudents][3];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + " (Physics, Chemistry, Maths):");
            for (int j = 0; j < 3; j++) {
                marks[i][j] = scanner.nextInt();
                if (marks[i][j] < 0) {
                    System.out.println("Marks cannot be negative. Re-enter marks.");
                    j--;
                }
            }
            percentages[i] = calculatePercentage(marks[i]);
            grades[i] = calculateGrade(percentages[i]);
        }
        
        System.out.println("Student Marks, Percentages, and Grades:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ": Physics = " + marks[i][0] + 
                ", Chemistry = " + marks[i][1] + ", Maths = " + marks[i][2] + 
                ", Percentage = " + percentages[i] + ", Grade = " + grades[i]);
        }
        
        scanner.close();
    }
    
    private static double calculatePercentage(int[] marks) {
        return (marks[0] + marks[1] + marks[2]) / 3.0;
    }
    
    private static char calculateGrade(double percentage) {
        if (percentage >= 80) return 'A';
        if (percentage >= 70) return 'B';
        if (percentage >= 60) return 'C';
        if (percentage >= 50) return 'D';
        if (percentage >= 40) return 'E';
        return 'F'; // For percentages below 40
    }
}

