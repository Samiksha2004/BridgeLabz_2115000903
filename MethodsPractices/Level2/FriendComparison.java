import java.util.Scanner;

public class FriendComparison {

    public static String findYoungest(int[] ages) {
        int minAge = ages[0];
        String youngest = "Amar";
        
        if (ages[1] < minAge) {
            minAge = ages[1];
            youngest = "Akbar";
        }
        if (ages[2] < minAge) {
            minAge = ages[2];
            youngest = "Anthony";
        }
        
        return youngest;
    }

    public static String findTallest(double[] heights) {
        double maxHeight = heights[0];
        String tallest = "Amar";
        
        if (heights[1] > maxHeight) {
            maxHeight = heights[1];
            tallest = "Akbar";
        }
        if (heights[2] > maxHeight) {
            maxHeight = heights[2];
            tallest = "Anthony";
        }
        
        return tallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        System.out.print("Enter the age of Amar: ");
        ages[0] = scanner.nextInt();
        System.out.print("Enter the height of Amar: ");
        heights[0] = scanner.nextDouble();
        
        System.out.print("Enter the age of Akbar: ");
        ages[1] = scanner.nextInt();
        System.out.print("Enter the height of Akbar: ");
        heights[1] = scanner.nextDouble();
        
        System.out.print("Enter the age of Anthony: ");
        ages[2] = scanner.nextInt();
        System.out.print("Enter the height of Anthony: ");
        heights[2] = scanner.nextDouble();
        
        String youngest = findYoungest(ages);
        String tallest = findTallest(heights);
        
        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
    }
}
