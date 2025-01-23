import java.util.Scanner;

public class YoungestAndTallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the age and height of Amar:");
        System.out.print("Age: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Height (in cm): ");
        int heightAmar = scanner.nextInt();

        System.out.println("Enter the age and height of Akbar:");
        System.out.print("Age: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Height (in cm): ");
        int heightAkbar = scanner.nextInt();

        System.out.println("Enter the age and height of Anthony:");
        System.out.print("Age: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Height (in cm): ");
        int heightAnthony = scanner.nextInt();

        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        String youngestFriend = (youngestAge == ageAmar) ? "Amar" : (youngestAge == ageAkbar) ? "Akbar" : "Anthony";

        int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        String tallestFriend = (tallestHeight == heightAmar) ? "Amar" : (tallestHeight == heightAkbar) ? "Akbar" : "Anthony";

        System.out.println("The youngest friend is " + youngestFriend + " with age " + youngestAge + ".");
        System.out.println("The tallest friend is " + tallestFriend + " with height " + tallestHeight + " cm.");

        
    }
}

