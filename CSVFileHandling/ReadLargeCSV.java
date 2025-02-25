import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_data.csv";
        int batchSize = 100;
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;
                totalRecords++;

                if (count == batchSize) {
                    System.out.println("Processed " + totalRecords + " records so far.");
                    count = 0;
                }
            }

            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
