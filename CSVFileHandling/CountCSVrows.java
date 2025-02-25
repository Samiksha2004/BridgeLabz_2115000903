

import java.io.*;

public class CountCSVrows {
    public static void main(String[] args) {
        String filePath = "employees.csv"; 
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

          
            br.readLine(); 

         
            while ((line = br.readLine()) != null) {
                rowCount++;
            }

            System.out.println("Total number of records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}

