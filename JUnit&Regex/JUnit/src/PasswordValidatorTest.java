import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidator {
    public static boolean isValid(String password) {
        if (password == null || password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        return true;
    }
}

public class PasswordValidatorTest {
    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Abcdefg1"));
    }

    @Test
    void testInvalidTooShort() {
        assertFalse(PasswordValidator.isValid("Abc1"));
    }

    @Test
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValid("abcdefg1"));
    }

    @Test
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValid("Abcdefgh"));
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null));
    }
}
