import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        Map<Integer, String[]> studentData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine();
            String line;
            while ((line = br1.readLine()) != null) {
                String[] columns = line.split(",");
                studentData.put(Integer.parseInt(columns[0]), new String[]{columns[1], columns[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            br2.readLine();
            String line;
            while ((line = br2.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0]);
                if (studentData.containsKey(id)) {
                    String[] existingData = studentData.get(id);
                    studentData.put(id, new String[]{existingData[0], existingData[1], columns[1], columns[2]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Map.Entry<Integer, String[]> entry : studentData.entrySet()) {
                String[] details = entry.getValue();
                bw.write(entry.getKey() + "," + String.join(",", details) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
