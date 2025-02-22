import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtils {
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        return str.equalsIgnoreCase(reverse(str));
    }

    public static String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}

public class StringUtilsSingle {
    @Test
    void testReverse() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
        assertEquals("racecar", StringUtils.reverse("racecar"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("RaceCar"));
        assertTrue(StringUtils.isPalindrome("a"));
        assertTrue(StringUtils.isPalindrome(""));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("", StringUtils.toUpperCase(""));
        assertNull(StringUtils.toUpperCase(null));
    }
}
