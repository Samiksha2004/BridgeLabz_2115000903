import java.io.*;
import java.util.*;
import org.json.*;

public class JSONCSVConverter {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";
        String jsonOutputFile = "students_output.json";

        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, jsonOutputFile);
    }

    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray jsonArray = new JSONArray(jsonString.toString());

            bw.write("ID,Name,Age,Marks\n");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                bw.write(obj.getInt("ID") + "," +
                         obj.getString("Name") + "," +
                         obj.getInt("Age") + "," +
                         obj.getDouble("Marks") + "\n");
            }
            System.out.println("JSON converted to CSV successfully.");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile))) {

            JSONArray jsonArray = new JSONArray();
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                JSONObject obj = new JSONObject();
                obj.put("ID", Integer.parseInt(columns[0]));
                obj.put("Name", columns[1]);
                obj.put("Age", Integer.parseInt(columns[2]));
                obj.put("Marks", Double.parseDouble(columns[3]));
                jsonArray.put(obj);
            }

            bw.write(jsonArray.toString(4));
            System.out.println("CSV converted to JSON successfully.");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
