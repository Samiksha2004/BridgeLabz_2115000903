import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        playGame();
    }
    
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;
        
        while (!guessedCorrectly) {
            int guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (Enter 'h' for high, 'l' for low, 'c' for correct)");
            char response = scanner.next().charAt(0);
            
            if (response == 'c') {
                guessedCorrectly = true;
                System.out.println("The computer guessed your number correctly!");
            } else if (response == 'h') {
                high = guess - 1;
            } else if (response == 'l') {
                low = guess + 1;
            }
        }
        
        scanner.close();
    }
    
    public static int generateGuess(int low, int high, Random random) {
        return low + random.nextInt(high - low + 1);
    }
}

