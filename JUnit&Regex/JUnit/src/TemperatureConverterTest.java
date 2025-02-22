import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}

public class TemperatureConverterTest {
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), 0.001);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), 0.001);
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37.0), 0.001);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), 0.001);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), 0.001);
        assertEquals(37.0, TemperatureConverter.fahrenheitToCelsius(98.6), 0.001);
    }
}
