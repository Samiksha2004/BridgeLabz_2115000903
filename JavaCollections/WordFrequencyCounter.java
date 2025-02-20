import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filename) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        return wordCount;
    }

    public static void main(String[] args) {
        String filename = "input.txt"; // Replace with your file path
        try {
            Map<String, Integer> wordFrequency = countWordFrequency(filename);
            System.out.println(wordFrequency);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

