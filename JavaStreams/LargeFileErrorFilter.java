import java.io.*;

class LargeFileErrorFilter {
    public static void main(String[] args) {
        File inputFile = new File("largefile.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
            System.out.println("File reading completed.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

