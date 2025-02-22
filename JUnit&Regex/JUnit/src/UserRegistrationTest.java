import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistration {
    public static void registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}

public class UserRegistrationTest {
    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> 
            UserRegistration.registerUser("john", "john@example.com", "Password123")
        );
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () ->
            UserRegistration.registerUser("", "john@example.com", "Password123")
        );
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
            UserRegistration.registerUser("john", "johnexample.com", "Password123")
        );
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () ->
            UserRegistration.registerUser("john", "john@example.com", "Pass1")
        );
    }
}
