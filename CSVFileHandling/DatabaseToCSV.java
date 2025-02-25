import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        String csvFile = "employees_report.csv";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            writer.write("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {
                writer.write(rs.getInt("id") + "," +
                             rs.getString("name") + "," +
                             rs.getString("department") + "," +
                             rs.getDouble("salary") + "\n");
            }

            System.out.println("CSV report generated successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
