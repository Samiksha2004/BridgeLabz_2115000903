import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; 

        
        String[] employees = {
            "101,John,HR,50000",
            "102,Alice,IT,60000",
            "103,Bob,Finance,55000",
            "104,Emma,Marketing,52000",
            "105,Charlie,Operations,58000"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            
            bw.write("ID,Name,Department,Salary");
            bw.newLine();

           
            for (String employee : employees) {
                bw.write(employee);
                bw.newLine();
            }

            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
