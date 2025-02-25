import java.io.*;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Path to the CSV file

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            

            br.readLine();

            System.out.println("Students who scored more than 80 marks:");

           
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); 

                
                String id = columns[0];
                String name = columns[1];
                int age = Integer.parseInt(columns[2]);
                int marks = Integer.parseInt(columns[3]);

                
                if (marks > 80) {
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
