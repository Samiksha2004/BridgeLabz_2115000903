import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int count = 0;
        int temp = number;
        
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }
        
        int[] digits = new int[count];
        
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        
        System.out.println("The digits in reverse order are:");
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i] + " ");
        }
    }
}

