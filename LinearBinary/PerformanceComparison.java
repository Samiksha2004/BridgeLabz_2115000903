import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // Measure time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long bufferTime = endTimeBuffer - startTimeBuffer;

        // Measure time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long builderTime = endTimeBuilder - startTimeBuilder;

        // Print concatenation performance results
        System.out.println("StringBuffer Time: " + bufferTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder Time: " + builderTime / 1_000_000.0 + " ms");

        // File reading performance comparison
        String filePath = "largefile.txt"; // Replace with a 100MB text file

        long fileReaderTime = countWordsUsingFileReader(filePath);
        long inputStreamReaderTime = countWordsUsingInputStreamReader(filePath);

        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000.0 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000.0 + " ms");
    }

    public static long countWordsUsingFileReader(String filePath) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split on spaces
            }

        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("Word count using FileReader: " + wordCount);
        return endTime - startTime;
    }

    public static long countWordsUsingInputStreamReader(String filePath) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split on spaces
            }

        } catch (IOException e) {
            System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("Word count using InputStreamReader: " + wordCount);
        return endTime - startTime;
    }
}

