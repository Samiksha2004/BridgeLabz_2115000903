import java.io.*;

public class WordCount {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by spaces and tabs
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // Case-insensitive match
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "example.txt"; // Change to your file path
        String targetWord = "hello"; // Word to search for

        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}

