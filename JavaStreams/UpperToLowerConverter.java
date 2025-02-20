import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("Conversion completed: All uppercase letters are now lowercase in output.txt");

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

