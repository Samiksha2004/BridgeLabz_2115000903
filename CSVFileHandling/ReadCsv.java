import java.io.*;

public class ReadCsv {
    public static void main(String[] args) {
         String filePath = "C:\\Users\\ASUS\\Desktop\\capgemini\\bridgeLabz_2115000909\\assignment25\\students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Read the header line (if present) and ignore it
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // Split the line by commas
                
                // Print each record in a structured format
                System.out.println("ID: " + columns[0] 
                                 + ", Name: " + columns[1] 
                                 + ", Age: " + columns[2] 
                                 + ", Marks: " + columns[3]);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the error message if an exception occurs
        }
    }
}
