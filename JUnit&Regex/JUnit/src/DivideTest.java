
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivideUtils {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class DivideTest {
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> DivideUtils.divide(5, 0));
    }
}
