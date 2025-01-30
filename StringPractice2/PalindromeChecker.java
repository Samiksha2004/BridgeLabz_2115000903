import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        checkPalindrome();
    }
    
    public static void checkPalindrome() {
        Scanner scanner = new Scanner(System.in);
        String input = getInput(scanner, "Enter a string: ");
        
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        
        scanner.close();
    }
    
    public static String getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    
    public static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

