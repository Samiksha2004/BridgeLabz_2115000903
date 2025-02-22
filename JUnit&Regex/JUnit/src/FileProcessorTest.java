import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class FileProcessor {
    public static void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public static String readFromFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString().trim();
    }
}

public class FileProcessorTest {
    @Test
    void testWriteAndRead() throws IOException {
        String filename = "testfile.txt";
        String content = "Hello World";
        FileProcessor.writeToFile(filename, content);
        assertTrue(new File(filename).exists());
        assertEquals(content, FileProcessor.readFromFile(filename));
    }

    @Test
    void testFileNotFound() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("non_existent_file.txt"));
    }
}
