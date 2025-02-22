
import java.util.regex.*;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$"; // Regex pattern
        return username.matches(regex);
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUsernames = { "user_123", "123user", "us", "valid_User", "U_12", "longusername_12345" };

        for (String username : testUsernames) {
            System.out.println(username + " → " + (isValidUsername(username) ? "Valid" : "Invalid"));
        }
    }
}
