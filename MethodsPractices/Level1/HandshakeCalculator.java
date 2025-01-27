import java.util.Scanner;

public class HandshakeCalculator {

    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        if (numberOfStudents < 2) {
            System.out.println("The number of students must be at least 2 for handshakes to occur.");
        } else {
            int maxHandshakes = calculateHandshakes(numberOfStudents);
            System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is: " + maxHandshakes);
        }
    }
}
