import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "user_input.txt"; // File to store user input

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true); // Append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(userInput);
                bufferedWriter.newLine();
            }

            System.out.println("User input saved to " + filePath);

        } catch (IOException e) {
            System.err.println("Error processing input/output: " + e.getMessage());
        }
    }
}

