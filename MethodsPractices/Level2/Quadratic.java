import java.util.Scanner;

public class Quadratic {

    public static double[] findRoots(int a, int b, int c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[] {root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[] {root};
        } else {
            return new double[] {};  // No real roots
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter coefficient a: ");
        int a = scanner.nextInt();
        System.out.print("Enter coefficient b: ");
        int b = scanner.nextInt();
        System.out.print("Enter coefficient c: ");
        int c = scanner.nextInt();
        
        double[] roots = findRoots(a, b, c);
        
        if (roots.length == 0) {
            System.out.println("No real roots.");
        } else if (roots.length == 1) {
            System.out.println("The root is: " + roots[0]);
        } else {
            System.out.println("The roots are: " + roots[0] + " and " + roots[1]);
        }
    }
}
