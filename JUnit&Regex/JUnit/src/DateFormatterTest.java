import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class DateFormatter {
    public static String formatDate(String inputDate) {
        if (inputDate == null) throw new IllegalArgumentException("Input date cannot be null");
        try {
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + inputDate);
        }
    }
}

public class DateFormatterTest {
    @Test
    void testValidDate() {
        assertEquals("15-09-2023", DateFormatter.formatDate("2023-09-15"));
    }

    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("09-15-2023"));
    }

    @Test
    void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(null));
    }
}
