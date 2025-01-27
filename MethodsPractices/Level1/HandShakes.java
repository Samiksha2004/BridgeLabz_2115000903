import java.util.Scanner;

public class HandShakes {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        System.out.println(calculateHandshakes(students));
    }
}

