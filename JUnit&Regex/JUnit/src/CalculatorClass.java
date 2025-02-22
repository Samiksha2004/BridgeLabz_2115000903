import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return a / b;
    }
}
public class CalculatorClass {

	 @Test
	    void testAddition() {
	        Calculator calc = new Calculator();
	        assertEquals(10, calc.add(5, 5));
	    }

	    @Test
	    void testSubtraction() {
	        Calculator calc = new Calculator();
	        assertEquals(2, calc.subtract(5, 3));
	    }

	    @Test
	    void testMultiplication() {
	        Calculator calc = new Calculator();
	        assertEquals(15, calc.multiply(3, 5));
	    }

	    @Test
	    void testDivision() {
	        Calculator calc = new Calculator();
	        assertEquals(4, calc.divide(8, 2));
	    }

	    @Test
	    void testDivisionByZero() {
	        Calculator calc = new Calculator();
	        Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
	        assertEquals("Cannot divide by zero!", exception.getMessage());
	    }

}
