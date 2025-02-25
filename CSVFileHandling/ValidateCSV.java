import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                Matcher emailMatcher = emailPattern.matcher(columns[2]);
                Matcher phoneMatcher = phonePattern.matcher(columns[3]);

                if (!emailMatcher.matches() || !phoneMatcher.matches()) {
                    System.out.println("Invalid record: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
