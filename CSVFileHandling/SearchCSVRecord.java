import java.io.*;

public class SearchCSVRecord {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String searchName = "John Doe";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];
                String name = columns[1];
                String department = columns[2];
                double salary = Double.parseDouble(columns[3]);

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
